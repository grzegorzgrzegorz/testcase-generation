package some_class_dsl;

import first_testcase.ParameterClosure;
import gherkin.GWT;

public class DslGenerator {
    String value;
    ParameterClosure givenDsl;
    ParameterClosure whenDsl;
    ParameterClosure thenDsl;

    public DslGenerator(String value) {
        this.value = value;
    }

    protected void setGivenDsl(ParameterClosure givenDsl) {
        this.givenDsl = givenDsl;
    }

    protected void setWhenDsl(ParameterClosure whenDsl) {
        this.whenDsl = whenDsl;
    }

    protected void setThenDsl(ParameterClosure thenDsl) {
        this.thenDsl = thenDsl;
    }

    public void generateDsl(GWT item) {
        if (item.equals(GWT.GIVEN) && givenDsl != null) {
            givenDsl.generate(item, value);
        } else if (item.equals(GWT.WHEN) && whenDsl != null) {
            whenDsl.generate(item, value);
        } else if (item.equals(GWT.THEN) && thenDsl != null) {
            thenDsl.generate(item, value);
        } else {
            System.out.println("Skipping: " + item.toString() + " for ");
        }
    }


}
