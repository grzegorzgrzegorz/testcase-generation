package gherkin;

public enum GWT {
    GIVEN("//Given"),
    WHEN("//When"),
    THEN("//Then");

    String name;
    private GWT(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
