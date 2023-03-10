package class_under_test;

import com.google.common.base.Preconditions;

public class MyUtil {

    static String capitalLetterPattern = "[A-Z]";

    public static String makeValidSentence(String input) {
        Preconditions.checkNotNull(input, "input is null!");
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
        return String.valueOf(firstLetter).toUpperCase() + restOfInput;
    }
}
