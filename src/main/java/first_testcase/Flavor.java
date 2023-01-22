package first_testcase;

import gherkin.GWT;

public class Flavor extends MyDslGenerator {

    String dslName;

    public Flavor(String dslName, String value){
        super(value);
        setWhenDsl(whenDsl);
        setThenDsl(thenDsl);
        this.dslName = dslName;
    }
    ParameterClosure whenDsl = (GWT item, String value) -> {
        String gwtPrefix = item.getName()+System.lineSeparator();
        System.out.println(gwtPrefix+
                "iceCream.add(new Flavor(" + value + "))");
    };

    ParameterClosure thenDsl = (GWT item, String value) -> {
        String gwtPrefix = item.getName()+System.lineSeparator();
        System.out.println(gwtPrefix+"assertTrue iceCream.tastesLike(" + value + ");");
    };

    public void generateDsl(GWT item) {
        if (value == "no"){
            return;
        }
        if (item.equals(GWT.WHEN)) {
            whenDsl.generate(item, dslName);
        } else if (item.equals(GWT.THEN)) {
            thenDsl.generate(item, dslName);
        } else {
            System.out.println("Unsupported: " + item.toString());
        }
    }


}
