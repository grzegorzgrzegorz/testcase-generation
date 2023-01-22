package first_testcase;

import gherkin.GWT;

public class MyDslGenerator {

    String value;
    ParameterClosure whenDsl;
    ParameterClosure thenDsl;
    public MyDslGenerator(String value){
        this.value = value;
    }

    protected void setWhenDsl(ParameterClosure whenDsl){
        this.whenDsl = whenDsl;
    }

    protected void setThenDsl(ParameterClosure thenDsl){
        this.thenDsl = thenDsl;
    }

    public void generateDsl(GWT item) {
        if (item.equals(GWT.WHEN)) {
            whenDsl.generate(item, value);
        } else if (item.equals(GWT.THEN)) {
            thenDsl.generate(item, value);
        } else {
            System.out.println("Unsupported: " + item.toString());
        }
    }

}
