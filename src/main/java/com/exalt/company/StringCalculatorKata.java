package com.exalt.company;

import java.util.Arrays;
import java.util.function.Predicate;

public class StringCalculatorKata {

//    int add(String numbers) {
//        throw new UnsupportedOperationException("Please, complete this method with your implementation");
//    }

//    step one :
    int add(String numbers) {
        return Arrays.stream(numbers.split(","))
                .filter(((Predicate<String>) String::isEmpty).negate())
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
