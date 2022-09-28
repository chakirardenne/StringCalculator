package com.exalt.company;

import java.util.Arrays;
import java.util.function.Predicate;

public class StringCalculatorKata {

//    int add(String numbers) {
//        throw new UnsupportedOperationException("Please, complete this method with your implementation");
//    }

//    step one :
//    int add(String numbers) {
//        if(numbers.isEmpty())
//            return 0;
//        String[] strings = numbers.split(",", 2);
//        return Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]);
//    }

//    step two :
    int add(String numbers) {
        return Arrays.stream(numbers.split(","))
                .filter(((Predicate<String>) String::isEmpty).negate())
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
