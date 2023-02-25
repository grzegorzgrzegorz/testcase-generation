package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    String text = "sample";

    List<String> activeOptions = new ArrayList<>();
    List<String> supportedOptions = Arrays.asList(
            "FirstLetterCapitalized",
            "NotFirstLetterCapitalized",
            "NoCapitals",
            "OneWord",
            "ManyWords",
            "DotPresentAtTheEnd",
            "DotPresentNotAtTheEnd",
            "NoDots");


    public void set(String option) {
        if (!supportedOptions.stream().anyMatch(item -> item.contentEquals(option))) {
            throw new RuntimeException("Unsupported: " + option);
        }
        activeOptions.add(option);
    }

    public String generate() {
        activeOptions.forEach(option -> runOption(option));
        return text;
    }

    private void runOption(String option) {
        if (Arrays.asList("OneWord", "NoCapitals","NoDots").stream().anyMatch(item -> item.contentEquals(option))) {
            return;
        }
        if (option.contentEquals("FirstLetterCapitalized")) {
            List<String> textAsList = Arrays.asList(text.split(""));
            String firstLetter = textAsList.get(0).toUpperCase();
            textAsList.set(0, firstLetter);
            text = String.join("", textAsList);
        } else if (option.contentEquals("DotPresentAtTheEnd")) {
            text = text + ".";
        }
        else if(option.contentEquals("NotFirstLetterCapitalized")){
            List<String> textAsList = Arrays.asList(text.split(""));
            String secondLetter = textAsList.get(1).toUpperCase();
            textAsList.set(1, secondLetter);
            text = String.join("", textAsList);
        }
        else if(option.contentEquals("ManyWords")){
            text = text+' '+text;
        }
        else if(option.contentEquals("DotPresentNotAtTheEnd")){
            List<String> wordsAsList = Arrays.asList(text.split(" "));
            List<String> newList = new ArrayList<>();
            for(int i=0; i < wordsAsList.size(); i++){
                newList.add(wordsAsList.get(i));
                if (i == 0){
                    newList.add("."+text);
                }
            }
            text = String.join(" ", newList);
        }
        else{
            throw new RuntimeException("Unsupported option: "+option);
        }
    }

}
