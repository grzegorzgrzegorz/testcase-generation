package core;

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

    public String generateDsl(GWT item) {
        if (item.equals(GWT.GIVEN) && givenDsl != null) {
            return givenDsl.generate(value);
        } else if (item.equals(GWT.WHEN) && whenDsl != null) {
            return whenDsl.generate(value);
        } else if (item.equals(GWT.THEN) && thenDsl != null) {
            return thenDsl.generate(value);
        }
        return("//Not found: " + item.toString());
    }


}
