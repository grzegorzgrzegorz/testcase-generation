package some_class;

public class MyUtil {

    static String capitalLetterPattern = "[A-Z]";

    public static String makeValidSentence(String input) {
        String output = input.trim();
        output = addDotIfRequired(output);
        output = capitalizeFirstLetterIfRequired(output);
        return output;
    }

    private static String addDotIfRequired(String input) {
        if (input.endsWith(".")) {
            return input;
        } else {
            return input + ".";
        }
    }

    private static String capitalizeFirstLetterIfRequired(String input) {
        char firstLetter = input.charAt(0);
        if (String.valueOf(firstLetter).matches(capitalLetterPattern)) {
            return input;
        }
        String restOfInput = input.substring(1);
        return firstLetter + restOfInput;
    }
}
