package some_class_dsl;

import gherkin.GWT;

public class Dots extends InputContent {


    public Dots(){
        this("");
    }
    public Dots(String value) {
        super(value);
        ParameterClosure givenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "dataGenerator.set(\""+inputValue+"\")");
        };

        ParameterClosure thenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "assertTrue result.matches(.*\\.);");
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);

    }

}
