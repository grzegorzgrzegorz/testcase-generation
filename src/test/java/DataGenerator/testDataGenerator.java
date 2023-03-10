package DataGenerator;

import org.junit.jupiter.api.Test;
import utils.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class testDataGenerator {


    @Test
    void testShouldThrowException_onUnsupportedValue() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        //WHEN
        Throwable exception = assertThrows(
                RuntimeException.class, () -> {
                    dataGenerator.set("UnsupportedParam");
                    dataGenerator.generate();
                });
        assert exception.getMessage().contains("Unsupported: UnsupportedParam");
    }

    @Test
    void testFirstLetterCapitalized_shouldMakeFirstLetterCapital() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("FirstLetterCapitalized");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches("[A-Z].*");
    }

    @Test
    void testNotFirstLetterCapitalized_shouldMakeAtLeastOne_NonFirstLetterCapital() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("NotFirstLetterCapitalized");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches("[a-z].*[A-Z].*");
    }

    @Test
    void testNoCapitals_shouldMakeAllLettersSmall() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("NoCapitals");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches("[a-z.]+");
    }

    @Test
    void testOneWord_shouldProduceStringWithoutWhiteSpaces() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("OneWord");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches("[a-zA-Z.]+");
    }

    @Test
    void testManyWords_shouldProduceStringWithAtLeastOneWhiteSpace() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("ManyWords");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches("([a-zA-Z.]+\\s+[a-zA-Z.]+)+");
    }

    @Test
    void testDotPresentAtTheEnd_shouldProduceStringWithDotAsTheLastCharacter() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("DotPresentAtTheEnd");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches(".*\\.");
    }

    @Test
    void testDotPresentNotAtTheEnd_shouldProduceStringWithDotAsAny_butNotTheLastCharacter() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("DotPresentNotAtTheEnd");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches(".*\\..+");
    }

    @Test
    void testMultipleOptionsAreApplied() {
        //GIVEN
        DataGenerator dataGenerator = new DataGenerator();
        dataGenerator.set("FirstLetterCapitalized");
        dataGenerator.set("ManyWords");
        dataGenerator.set("DotPresentAtTheEnd");
        //WHEN
        String result = dataGenerator.generate();
        //THEN
        assert result.matches("[A-Z].*");
        assert result.matches("([a-zA-Z.]+\\s+[a-zA-Z.]+)+");
        assert result.matches(".*\\.");
    }

}
