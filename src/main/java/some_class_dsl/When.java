package some_class_dsl;

import gherkin.GWT;

public class When extends DslGenerator {

    public When(String value) {
        super(value);
        ParameterClosure whenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "String text = dataGenerator.generate();"+System.lineSeparator()+
                    "String result = MyUtil.makeValidSentence(text);"
            );
        };

        setWhenDsl(whenDsl);
    }
}
