package com.exalt.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;-2", "//;\n-1;2", "//;\n-1;-2"})
    void addWithNegatives(String string) {
        assertThrows(UnsupportedOperationException.class, () -> stringCalculatorKata.add(string));
    }

    private static Stream<Arguments> addProvider() {
        return Stream.of(
                arguments("1,2", 3),
                arguments("1\n2,3", 6),
                arguments("//;\n1;2", 3),
                arguments("", 0)
        );
    }

}