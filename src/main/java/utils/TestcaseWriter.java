package utils;

import core.DslGenerator;
import gherkin.GWT;
import some_class_dsl.When;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TestcaseWriter {


    static Path generatedDirectory = Paths.get("src", "test", "java", "generated", "testSomeClass.java");

    public static void write(List<DslGenerator> variableCombination) throws IOException {
        printHeader();
        printTestcases(variableCombination);
        printFooter();
    }

    private static void printHeader() throws IOException {
        String text = "header";
        Files.write(generatedDirectory, text.getBytes(), StandardOpenOption.WRITE);
    }

    private static void printFooter() throws IOException {
        String text = "footer";
        Files.write(generatedDirectory, text.getBytes(), StandardOpenOption.APPEND);
    }

    private static void printTestcases(List<DslGenerator> variableCombination) throws IOException {

        Files.write(generatedDirectory, ("//" + GWT.GIVEN).getBytes(), StandardOpenOption.APPEND);
        Files.write(generatedDirectory, "DataGenerator dataGenerator = new DataGenerator();".getBytes(), StandardOpenOption.APPEND);
        variableCombination.forEach(item -> item.generateDsl(GWT.GIVEN));

        Files.write(generatedDirectory, ("//" + GWT.WHEN).getBytes(), StandardOpenOption.APPEND);
        new When("").generateDsl(GWT.WHEN);

        Files.write(generatedDirectory, ("//" + GWT.THEN).getBytes(), StandardOpenOption.APPEND);
        variableCombination.forEach(item -> item.generateDsl(GWT.THEN));
    }

}