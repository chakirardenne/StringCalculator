package com.exalt.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringCalculatorKataTest {
    StringCalculatorKata stringCalculatorKata;

    @BeforeEach
    void setUp() {
        stringCalculatorKata = new StringCalculatorKata();
    }

    @AfterEach
    void tearDown() {
        stringCalculatorKata = null;
    }

    @ParameterizedTest(name = "{index} => string={0}, sum={1}")
    @MethodSource("addProvider")
    void add(String string, int sum) {
        assertEquals(stringCalculatorKata.add(string), sum);
    }

    private static Stream<Arguments> addProvider() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("50,550", 600),
                arguments("3,7", 10),
                arguments("3,2", 5),
                arguments("1\n2,3", 6),
                arguments("1\n2,3\n,6,\n7", 19),
                arguments("", 0)
        );
    }

}