package some_class_dsl;

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
            return "assert result.matches(\".*\\\\.\");";
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);

    }

}
