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
//    int add(String numbers) {
//        return Arrays.stream(numbers.split(","))
//                .filter(((Predicate<String>) String::isEmpty).negate())
//                .map(Integer::parseInt)
//                .reduce(Integer::sum)
//                .orElse(0);
//    }

//    step three :
//    int add(String numbers) {
//        return Arrays.stream(numbers.split("[,\n]"))
//                .filter(((Predicate<String>) String::isEmpty).negate())
//                .map(Integer::parseInt)
//                .reduce(Integer::sum)
//                .orElse(0);
//    }

//    step four :
    int add(String numbers) {
        String delimiter = ",";
        if(numbers.contains("//")) {
            delimiter = String.valueOf(numbers.charAt(numbers.lastIndexOf("/") + 1));
        }
        if(!delimiter.equals(","))
            numbers = numbers.substring(numbers.indexOf("\n"));
        return Arrays.stream(numbers.split(String.format("[%s\n]", delimiter)))
                .filter(((Predicate<String>) String::isEmpty).negate())
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
