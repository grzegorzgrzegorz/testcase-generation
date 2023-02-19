package first_testcase;

import gherkin.GWT;
import some_class_dsl.ParameterClosure;

public class Cone extends MyDslGenerator {

    ParameterClosure whenDsl = (GWT item, String value) -> {
        String gwtPrefix = item.getName() + System.lineSeparator();
        System.out.println(gwtPrefix +
                "IceCream iceCream = new IceCream();"
                + System.lineSeparator() +
                "Cone cone = new Cone(" + value + ")"
                + System.lineSeparator() +
                "iceCream.add(cone)"
        );
    };

    ParameterClosure thenDsl = (GWT item, String value) -> {
        String gwtPrefix = item.getName() + System.lineSeparator();
        System.out.println(gwtPrefix +
                "assertTrue iceCream.hasCone("+value+");");
    };


    public Cone(String value){
        super(value);
        setWhenDsl(whenDsl);
        setThenDsl(thenDsl);
    }

}
