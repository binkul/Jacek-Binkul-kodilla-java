package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Jacek Binkul", text -> "### " + text + " ###");
        poemBeautifier.beautify("Lato było przedziwne tego roku", text -> text.replaceAll(" ", "_"));
        poemBeautifier.beautify("jacekbinkul", text -> text + "@gmail.com");
        poemBeautifier.beautify("Jacek binkul", text -> text.toUpperCase());
        poemBeautifier.beautify("Jacek     Binkul    pisze     programy", text -> text.replaceAll(" {2,}", " "));

        PoemDecorator poemDecorator = (text) -> {
            String result = "";
            for (int i = text.length() - 1; i >= 0; i--) {
                result += text.charAt(i);
            }
            return result;
        };
        System.out.println("Text from back: " + poemDecorator.decorate("Jacek Binkul"));
        System.out.println();

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
