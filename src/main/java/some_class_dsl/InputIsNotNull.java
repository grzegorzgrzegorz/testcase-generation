package some_class_dsl;

import core.DslGenerator;
import core.ParameterClosure;

public class InputIsNotNull extends DslGenerator {


    public InputIsNotNull(){
        this("");
    }
    public InputIsNotNull(String value) {
        super(value);
        if (value == "no") {
            ParameterClosure thenDsl = (String inputValue) -> {
                return "assertTrue result.isEmpty();";
            };
            setThenDsl(thenDsl);
        }
    }

}
