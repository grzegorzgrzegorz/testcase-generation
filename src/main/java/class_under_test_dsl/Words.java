package class_under_test_dsl;

import core.ParameterClosure;

public class Words extends InputContent {

    public Words() {
        this("");
    }

    public Words(String value) {
        super(value);


        ParameterClosure givenDsl = (String inputValue) -> {
            if (!inputValue.isEmpty()) {
                return "dataGenerator.set(\"" + inputValue + "\");";
            }
            return "//N/A";
        };

        ParameterClosure thenDsl = (String inputValue) -> {
            if (inputValue.contentEquals("ManyWords")){
                return "assert result.matches(\".*[ ]+.*\\\\.\");";
            } else if (inputValue.contentEquals("OneWord")) {
                return "assert result.matches(\"[a-zA-Z.]+\");";
            } else {
                return "//N/A";
            }
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }


}
