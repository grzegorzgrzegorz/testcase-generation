package some_class_dsl;

import gherkin.GWT;

public class InputIsNotNull extends DslGenerator {


    public InputIsNotNull(){
        this("");
    }
    public InputIsNotNull(String value) {
        super(value);
        if (value == "no") {
            ParameterClosure thenDsl = (GWT item, String inputValue) -> {
                String gwtPrefix = item.getName() + System.lineSeparator();
                System.out.println(gwtPrefix +
                        "assertTrue result.isEmpty();");
            };
        }
        setThenDsl(thenDsl);
    }

}
