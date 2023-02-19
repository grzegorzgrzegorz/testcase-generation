package some_class_dsl;

import gherkin.GWT;

public class When extends DslGenerator {

    public When(String value) {
        super(value);
        ParameterClosure whenDsl = (String inputValue) -> {
            System.out.println(
                    "String text = dataGenerator.generate();"+System.lineSeparator()+
                    "String result = MyUtil.makeValidSentence(text);"
            );
        };

        setWhenDsl(whenDsl);
    }
}
