package com.exalt.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringCalculatorKata {
    static final Predicate<String> isEmpty = String::isEmpty;
    static final Predicate<Integer> isNegative = number -> number < 0;

    private String delimiter = ",";

    int add(String numbers) {
        this.setNewDelimiter(numbers);
        numbers = this.stripStringOfNewDelimiterLine(numbers);
        this.hasNegative(numbers, delimiter);
        return Arrays.stream(numbers.split(String.format("[%s\n]", delimiter)))
                .filter(isEmpty.negate())
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private String stripStringOfNewDelimiterLine(String numbers) {
        if(!isDelimiterByDefault())
            numbers = numbers.substring(numbers.indexOf("\n"));
        return numbers;
    }

    private boolean isDelimiterByDefault() {
        return delimiter.equals(",");
    }

    private void setNewDelimiter(String numbers) {
        if(numbers.startsWith("//"))
            delimiter = String.valueOf(numbers.charAt(numbers.lastIndexOf("/") + 1));
    }

    private void hasNegative(String numbers, String delimiter) {
        List<Integer> negatives = this.getNegativesIntegers(numbers, delimiter);
        if(!negatives.isEmpty())
            throw new UnsupportedOperationException(String.format("Negatives numbers are not supported: %s", negatives));

    }

    private List<Integer> getNegativesIntegers(String numbers, String delimiter) {
        return Arrays.stream(numbers.split(String.format("[%s\n]", delimiter)))
                .filter(isEmpty.negate())
                .map(Integer::parseInt)
                .filter(isNegative)
                .collect(Collectors.toList());
    }
}
