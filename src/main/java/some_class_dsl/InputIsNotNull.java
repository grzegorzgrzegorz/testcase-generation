package some_class_dsl;

import gherkin.GWT;

public class InputIsNotNull extends DslGenerator {


    public InputIsNotNull(){
        this("");
    }
    public InputIsNotNull(String value) {
        super(value);
        ParameterClosure whenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "String result = MyUtil.makeValidSentence(text);"
            );
        };

        ParameterClosure thenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "assertTrue result.isEmpty();");
        };
        setWhenDsl(whenDsl);
        setThenDsl(thenDsl);
    }


    public void generateDsl(GWT item) {
        if (value == "yes") {
            return;
        }
        super.generateDsl(item);
    }
}
