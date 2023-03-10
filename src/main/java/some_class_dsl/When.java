package some_class_dsl;

import core.DslGenerator;
import core.ParameterClosure;

public class When extends DslGenerator {

    public When(String value) {
        super(value);
        ParameterClosure whenDsl = (String inputValue) -> {
            return "String text = dataGenerator.generate();//"+System.lineSeparator()+
                    "String result = MyUtil.makeValidSentence(text);";
        };

        setWhenDsl(whenDsl);
    }
}
