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
                    "text = " + inputValue);
        };

        ParameterClosure thenDsl = (GWT item, String inputValue) -> {
            String gwtPrefix = item.getName() + System.lineSeparator();
            System.out.println(gwtPrefix +
                    "assertTrue result.containsSpace();");
        };

        setGivenDsl(givenDsl);
        setThenDsl(thenDsl);
    }

}
