package class_under_test_dsl;

import core.DslGenerator;
import core.ParameterClosure;

public class InputIsNotNull extends DslGenerator {


    public InputIsNotNull() {
        this("");
    }

    public InputIsNotNull(String value) {
        super(value);
        ParameterClosure whenDsl = (String inputValue) -> {
            if (inputValue.contentEquals("No")) {
                return "String text = null;";
            } else {
                return "String text = dataGenerator.generate();";
            }
        };

        ParameterClosure thenDsl = (String inputValue) -> {
            return "//N/A";
        };

        setWhenDsl(whenDsl);
        setThenDsl(thenDsl);
    }

}
