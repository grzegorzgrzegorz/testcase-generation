import core.DslGenerator;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.TestcaseWriter;
import utils.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TestcaseGenerator {

    public static void main(String[] args) throws URISyntaxException, IOException {
        new TestcaseGenerator();
    }

    public TestcaseGenerator() throws URISyntaxException, IOException {
        JSONArray testcaseList = getTestcases("MyUtil-Test.json");
        TestcaseWriter.createTestclass();
        for (Object testcase : testcaseList) {
            try {
                int testcaseId = ((JSONObject) testcase).getInt("id");
                List<DslGenerator> variableCombination = getVariableCombination(((JSONObject) testcase).getJSONObject("arg"));
                TestcaseWriter.write(testcaseId, variableCombination);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        TestcaseWriter.finalizeTestclass();
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

}
