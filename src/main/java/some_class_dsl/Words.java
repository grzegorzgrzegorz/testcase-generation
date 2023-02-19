package some_class_dsl;

import gherkin.GWT;

public class Words extends InputContent {

    public Words(){
        this("");
    }
    public Words(String value) {
        super(value);


        ParameterClosure givenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "dataGenerator.set(\""+inputValue+"\")");
        };

        if(value == "ManyWords") {
            ParameterClosure thenDsl = (GWT item, String inputValue) -> {
                String gwtPrefix = item.getName() + System.lineSeparator();
                System.out.println(gwtPrefix +
                        "assertTrue result.matches(.*[ ].*\\.);");
            };
        }

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }

}
