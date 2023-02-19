package some_class_dsl;

import gherkin.GWT;

public class Dots extends InputContent {


    public Dots(){
        this("");
    }
    public Dots(String value) {
        super(value);
        ParameterClosure givenDsl = (String inputValue) -> {
            System.out.println(
                    "dataGenerator.set(\""+inputValue+"\")");
        };

        ParameterClosure thenDsl = (String inputValue) -> {
            System.out.println(
                    "assertTrue result.matches(.*\\.);");
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);

    }

}
