package dev.archie.complexnumber;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComplexScannerTest {

    @ParameterizedTest
    @MethodSource("getSourcesForComplexScanner")
    void nextComplexShouldReturnRightComplexNumber(Scanner scanner, ComplexNumber expected) {
        ComplexScanner complexScanner = new ComplexScanner(scanner);
        ComplexNumber actual = complexScanner.nextComplex();
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> getSourcesForComplexScanner() {
        List<ComplexNumber> complexNumbers = List.of(
            new ComplexNumber(1, 2),
            new ComplexNumber(1.2, 2),
            new ComplexNumber(1.2, -0.1)
        );

        return complexNumbers.stream()
            .map((complexNumber) -> Arguments.of(complexNumber.toString(), complexNumber));
    }
}