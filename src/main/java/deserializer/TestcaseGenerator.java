package deserializer;

import core.DslGenerator;
import gherkin.GWT;
import org.json.JSONArray;
import org.json.JSONObject;
import some_class_dsl.When;
import utils.Utils;

import java.net.URISyntaxException;
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

    public JSONArray getTestcases(String fileName) throws URISyntaxException {
        JSONObject jsonObject = Utils.getParsedJson(fileName);
        return (JSONArray) ((JSONObject) jsonObject.get("makeValidSentence")).get("testCases");
    }

    public List<DslGenerator> getVariableCombination(JSONObject jsonObject) throws URISyntaxException {
        List<DslGenerator> inputCombination = new ArrayList<>();
        jsonObject.keySet().forEach(keyName -> inputCombination.add(Utils.getDeserializedInstance(keyName, jsonObject)));
        return inputCombination;
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
}
