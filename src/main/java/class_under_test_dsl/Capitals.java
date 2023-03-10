package class_under_test_dsl;

import core.ParameterClosure;

public class Capitals extends InputContent {

    public Capitals() {
        this("");
    }

    public Capitals(String value) {
        super(value);

        ParameterClosure givenDsl = (String inputValue) -> {
            if (!inputValue.isEmpty()) {
                return "dataGenerator.set(\"" + inputValue + "\");";
            }
            return "//N/A";
        };

        ParameterClosure thenDsl = (String inputValue) -> {
            if (!inputValue.isEmpty()) {
                return "assert result.matches(\"[A-Z].*\");";
            }
            return "//N/A";
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }

}
