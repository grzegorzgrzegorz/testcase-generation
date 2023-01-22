package main;

import first_testcase.*;
import gherkin.GWT;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        new Start();
    }

    public Start() {
        //TCases work
        List<MyDslGenerator> tcasesOutputTc1 = new ArrayList<>();
        tcasesOutputTc1.add(new Cone("plain"));
        tcasesOutputTc1.add(new Vanilla("yes"));
        tcasesOutputTc1.add(new Chocolate("yes"));
        tcasesOutputTc1.add(new Strawberry("no"));

        tcasesOutputTc1.forEach(item -> item.generateDsl(GWT.WHEN));
        tcasesOutputTc1.forEach(item -> item.generateDsl(GWT.THEN));
    }
}
