package some_class_dsl;

import core.ParameterClosure;

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

        setGivenDsl(givenDsl);
        if(value == "ManyWords") {
            ParameterClosure thenDsl = (String inputValue) -> {
                System.out.println(
                        "assertTrue result.matches(.*[ ].*\\.);");
            };
            setThenDsl(thenDsl);
        }

    }

}
