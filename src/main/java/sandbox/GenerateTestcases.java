package sandbox;

import core.DslGenerator;
import gherkin.GWT;
import some_class_dsl.*;

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

        System.out.println(GWT.GIVEN);
        inputCombination.forEach(item -> item.generateDsl(GWT.GIVEN));

        System.out.println(GWT.WHEN);
        new When("").generateDsl(GWT.WHEN);

        System.out.println(GWT.THEN);
        inputCombination.forEach(item -> item.generateDsl(GWT.THEN));
    }
}
