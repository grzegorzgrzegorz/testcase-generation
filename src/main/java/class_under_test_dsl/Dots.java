package class_under_test_dsl;

import core.ParameterClosure;

public class Dots extends InputContent {


    public Dots(){
        this("");
    }
    public Dots(String value) {
        super(value);
        ParameterClosure givenDsl = (String inputValue) -> {
        if (!inputValue.isEmpty()) {
            return "dataGenerator.set(\"" + inputValue + "\");";
        }
        return "//N/A";
        };

        ParameterClosure thenDsl = (String inputValue) -> {
            if (!inputValue.isEmpty()) {
                return "assert result.matches(\".*\\\\.$\");";
            }
            return "//N/A";
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);

    }

}
