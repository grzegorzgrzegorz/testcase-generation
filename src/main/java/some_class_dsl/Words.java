package some_class_dsl;

import gherkin.GWT;

public class Words extends InputContent {

    public Words(){
        this("");
    }
    public Words(String value) {
        super(value);


        ParameterClosure givenDsl = (String inputValue) -> {
            System.out.println(
                    "dataGenerator.set(\""+inputValue+"\")");
        };

        if(value == "ManyWords") {
            ParameterClosure thenDsl = (String inputValue) -> {
                System.out.println(
                        "assertTrue result.matches(.*[ ].*\\.);");
            };
        }

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }

}
