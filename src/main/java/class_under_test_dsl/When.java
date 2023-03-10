package class_under_test_dsl;

import core.DslGenerator;
import core.ParameterClosure;

public class When extends DslGenerator {

    public When(String value) {
        super(value);
        ParameterClosure whenDsl = (String inputValue) -> {
            return "String result = MyUtil.makeValidSentence(text);";
        };

        setWhenDsl(whenDsl);
    }
}
