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

    static Path generatedDirectory = Paths.get("src", "test", "java", "generated", "testMyUtil.java");
    static String newLine = System.lineSeparator();


    public static void createTestclass() throws IOException {
        createFileIfNotExists();
        printHeader();
    }

    public static void finalizeTestclass() throws IOException {
        printFooter();
    }

    public static void write(int testcaseId, List<DslGenerator> variableCombination) throws IOException {
        printTestcase(testcaseId, variableCombination);
    }

    private static void createFileIfNotExists() throws IOException {
        Files.deleteIfExists(generatedDirectory);
        Files.createFile(generatedDirectory);
    }

    private static void writeLine(String text, Class classEntity) throws IOException {
        putLine(StandardOpenOption.WRITE, text, classEntity);
    }

    private static void appendLine(String text, Class classEntity) throws IOException {
        putLine(StandardOpenOption.APPEND, text, classEntity);
    }

    private static void putLine(StandardOpenOption standardOpenOption, String text, Class classEntity) throws IOException {
        String commentString = "";
        if (classEntity != null) {
            commentString = comment(classEntity.getSimpleName());
        }
        Files.write(generatedDirectory, (text + commentString + newLine).getBytes(), standardOpenOption);
    }

    private static void printHeader() throws IOException {
        writeLine("package generated;", TestcaseWriter.class);
        appendLine("import org.junit.jupiter.api.Test;", TestcaseWriter.class);
        appendLine("import some_class.MyUtil;", TestcaseWriter.class);
        appendLine("import utils.DataGenerator;", TestcaseWriter.class);
        appendLine("", null);
        appendLine("public class testMyUtil {", TestcaseWriter.class);
    }

    private static void printFooter() throws IOException {
        appendLine("}", null);
    }

    private static String comment(String text) {
        return " //" + text;
    }

    private static void printTestcase(int testcaseId, List<DslGenerator> variableCombination) throws IOException {
        appendLine("", null);
        appendLine("@Test", null);
        appendLine("void test" + testcaseId + "(){", TestcaseWriter.class);
        appendLine("//" + GWT.GIVEN, null);
        appendLine("DataGenerator dataGenerator = new DataGenerator();", TestcaseWriter.class);
        variableCombination.forEach(item -> {
            try {
                appendLine(item.generateDsl(GWT.GIVEN), item.getClass());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        appendLine("//" + GWT.WHEN, null);
        appendLine(new When("").generateDsl(GWT.WHEN), When.class);

        appendLine("//" + GWT.THEN, null);
        variableCombination.forEach(item -> {
            try {
                appendLine(item.generateDsl(GWT.THEN), item.getClass());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        appendLine("}", TestcaseWriter.class);
    }

}
