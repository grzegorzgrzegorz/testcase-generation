package some_class_dsl;

import gherkin.GWT;

public class Capitals extends InputContent {

    public Capitals(){
        this("");
    }

    public Capitals(String value) {
        super(value);

        ParameterClosure givenDsl = (String inputValue) -> {
            System.out.println(
                    "dataGenerator.set(\""+inputValue+"\")");
        };

        ParameterClosure thenDsl = (String inputValue) -> {
            System.out.println(
                    "assertTrue result.matches([A-Z].*);");
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }

}
