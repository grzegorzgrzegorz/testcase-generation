package some_class_dsl;

import gherkin.GWT;

public class InputIsNotNull extends DslGenerator {


    public InputIsNotNull(){
        this("");
    }
    public InputIsNotNull(String value) {
        super(value);
        if (value == "no") {
            ParameterClosure thenDsl = (String inputValue) -> {
                System.out.println(
                        "assertTrue result.isEmpty();");
            };
        }
        setThenDsl(thenDsl);
    }

}
