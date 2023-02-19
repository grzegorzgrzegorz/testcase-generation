package some_class_dsl;

import gherkin.GWT;

public interface ParameterClosure{
    public void generate(GWT item, String value);
}
