package some_class_dsl;

import gherkin.GWT;

import java.util.ArrayList;
import java.util.List;

public class GenerateTestcases {

    public static void main(String[] args) {
        new GenerateTestcases();
    }

    public GenerateTestcases() {
        List<DslGenerator> inputCombination = new ArrayList<>();
        inputCombination.add(new InputIsNotNull("yes"));
        inputCombination.add(new Words("One"));
        inputCombination.add(new Dots("PresentAtTheEnd"));
        inputCombination.add(new Capitals("FirstLetterCapitalized"));
        System.out.println("String text;");
        inputCombination.forEach(item -> item.generateDsl(GWT.GIVEN));
        new When("").generateDsl(GWT.WHEN);
        inputCombination.forEach(item -> item.generateDsl(GWT.THEN));
    }
}
