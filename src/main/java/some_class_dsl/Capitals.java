package some_class_dsl;

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
            return "assert result.matches(\"[A-Z].*\");";
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }

}
