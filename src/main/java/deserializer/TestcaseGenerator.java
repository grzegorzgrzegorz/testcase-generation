package deserializer;

import com.google.gson.Gson;
import core.DslGenerator;
import gherkin.GWT;
import org.json.JSONArray;
import org.json.JSONObject;
import some_class_dsl.When;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestcaseGenerator {

    public static void main(String[] args) throws URISyntaxException {
        new TestcaseGenerator();
    }

    public TestcaseGenerator() throws URISyntaxException {
        JSONArray testcaseList = getTestcases("MyUtil-Test.json");
        testcaseList.forEach(testcase -> {
                    try {
                        List<DslGenerator> variableCombination = getVariableCombination(((JSONObject) testcase).getJSONObject("arg"));
                        printTestcase(variableCombination);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    public void printTestcase(List<DslGenerator> variableCombination) {
        System.out.println("//" + GWT.GIVEN);
        System.out.println("DataGenerator dataGenerator = new DataGenerator();");
        variableCombination.forEach(item -> item.generateDsl(GWT.GIVEN));

        System.out.println("//" + GWT.WHEN);
        new When("").generateDsl(GWT.WHEN);

        System.out.println("//" + GWT.THEN);
        variableCombination.forEach(item -> item.generateDsl(GWT.THEN));
    }

    public JSONArray getTestcases(String fileName) throws URISyntaxException {
        JSONObject jsonObject = getParsedJson(fileName);
        return (JSONArray) ((JSONObject) jsonObject.get("makeValidSentence")).get("testCases");
    }

    public List<DslGenerator> getVariableCombination(JSONObject jsonObject) throws URISyntaxException {
        List<DslGenerator> inputCombination = new ArrayList<>();
        jsonObject.keySet().forEach(keyName -> inputCombination.add(getSerializedInstance(keyName, jsonObject)));
        return inputCombination;
    }

    private JSONObject getParsedJson(String fileName) {
        Path path = null;
        try {
            path = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String json = null;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new JSONObject(json);
    }

    public DslGenerator getSerializedInstance(String varName, JSONObject jsonObject) {
        Class className = getClassFromVarName(varName);
        String serializedClass = jsonObject.get(varName).toString();
        return new Gson().fromJson(serializedClass, (Type) className);
    }

    private Class getClassFromVarName(String varName) {
        try {
            if (varName.contains(".")) {
                varName = varName.split("\\.")[1];
            }
            return Class.forName("some_class_dsl." + varName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
