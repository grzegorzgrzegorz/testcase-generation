package some_class_dsl;

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
            givenDsl.generate(value);
        } else if (item.equals(GWT.WHEN) && whenDsl != null) {
            whenDsl.generate(value);
        } else if (item.equals(GWT.THEN) && thenDsl != null) {
            thenDsl.generate(value);
        } else {
            System.out.println("//Not found: " + item.toString() + " for "+ this.getClass().getSimpleName() + " class");
        }
    }


}
