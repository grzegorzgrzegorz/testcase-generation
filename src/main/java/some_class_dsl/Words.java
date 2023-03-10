package some_class_dsl;

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

        setGivenDsl(givenDsl);
        ParameterClosure thenDsl = (String inputValue) -> {
            if (value == "ManyWords") {
                return "assert result.matches(\".*[ ]+.*\\\\.\");";
            } else {
                return "assert result.matches(\"[a-zA-Z.]+\");";
            }
        };
        setThenDsl(thenDsl);
    }


}
