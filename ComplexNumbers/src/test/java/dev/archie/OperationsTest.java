package dev.archie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OperationsTest {

    @ParameterizedTest
    @MethodSource("getSourceForAdd")
    void addComplexNumberShouldReturnRightComplexNumber(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2, ComplexNumber expected) {
        ComplexNumber actual = Operations.add(complexNumber1, complexNumber2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForAddWithDouble")
    void addDoubleShouldReturnRightComplexNumber(ComplexNumber complexNumber, double toAdd,
        ComplexNumber expected) {
        ComplexNumber actual = Operations.add(complexNumber, toAdd);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForMultiply")
    void multiplyToComplexNumberShouldReturnRightComplexNumber(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2,
        ComplexNumber expected) {
        ComplexNumber actual = Operations.multiply(complexNumber1, complexNumber2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForMultiplyWithDouble")
    void multiplyToDoubleShouldReturnRightComplexNumber(ComplexNumber complexNumber,
        double toMultiply, ComplexNumber expected) {
        ComplexNumber actual = Operations.multiply(complexNumber, toMultiply);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForSubtract")
    void subtractToComplexNumberShouldReturnRightComplexNumber(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2,
        ComplexNumber expected) {
        ComplexNumber actual = Operations.subtract(complexNumber1, complexNumber2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForSubtractWithDouble")
    void subtractToDoubleShouldReturnRightComplexNumber(ComplexNumber complexNumber, double toAdd,
        ComplexNumber expected) {
        ComplexNumber actual = Operations.subtract(complexNumber, toAdd);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForDivide")
    void divideToComplexShouldReturnRightComplexNumber(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2,
        ComplexNumber expected) {
        ComplexNumber actual = Operations.divide(complexNumber1, complexNumber2);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForDivideWithDouble")
    void divideToNumberShouldReturnRightComplexNumber(ComplexNumber complexNumber, double toDivide, ComplexNumber expected) {
        ComplexNumber actual = Operations.divide(complexNumber, toDivide);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForAbsolute")
    void absoluteShouldReturnRightAbsoluteNumber(ComplexNumber complexNumber, double expected) {
        double actual = Operations.absolute(complexNumber);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForArgument")
    void argumentShouldReturnRightArgumentOfComplexNumber(ComplexNumber complexNumber,
        double expected) {
        double actual = Operations.argument(complexNumber);
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> getSourceForMultiply() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 1),
                new ComplexNumber(1, 1),
                new ComplexNumber(0, 2)
            ),
            Arguments.of(
                new ComplexNumber(2, 10),
                new ComplexNumber(3, 7),
                new ComplexNumber(-64, 44)
            )
        );
    }

    public static Stream<Arguments> getSourceForAdd() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 1),
                new ComplexNumber(1, 1),
                new ComplexNumber(2, 2)
            ),
            Arguments.of(
                new ComplexNumber(1, 2),
                new ComplexNumber(2, 3),
                new ComplexNumber(3, 5)
            )
        );
    }

    public static Stream<Arguments> getSourceForSubtract() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 1),
                new ComplexNumber(1, 1),
                new ComplexNumber(0)
            ),
            Arguments.of(
                new ComplexNumber(3, 1),
                new ComplexNumber(5, 4),
                new ComplexNumber(-2, -3)
            )
        );
    }

    public static Stream<Arguments> getSourceForDivide() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 1),
                new ComplexNumber(1, 1),
                new ComplexNumber(1)
            ),
            Arguments.of(
                new ComplexNumber(20, 5),
                new ComplexNumber(5),
                new ComplexNumber(4, 1)
            ),
            Arguments.of(
                new ComplexNumber(20, 10),
                new ComplexNumber(5, 5),
                new ComplexNumber(3, -1)
            )
        );
    }

    public static Stream<Arguments> getSourceForAbsolute() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 0),
                1
            ),
            Arguments.of(
                new ComplexNumber(0, 1),
                1
            ),
            Arguments.of(
                new ComplexNumber(3, 4),
                5
            )
        );
    }

    public static Stream<Arguments> getSourceForArgument() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(0, 10),
                Math.PI / 2
            ),
            Arguments.of(
                new ComplexNumber(0, -10),
                -Math.PI / 2
            ),
            Arguments.of(
                new ComplexNumber(-2, 4),
                Math.PI - Math.atan(2.0)
            ),
            Arguments.of(
                new ComplexNumber(1, -Math.sqrt(3)),
                -Math.PI / 3
            )
        );
    }


    public static Stream<Arguments> getSourceForAddWithDouble() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 1),
                2,
                new ComplexNumber(3, 1)
            )
        );
    }

    public static Stream<Arguments> getSourceForSubtractWithDouble() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(1, 2),
                2,
                new ComplexNumber(-1, 2)
            )
        );
    }

    public static Stream<Arguments> getSourceForMultiplyWithDouble() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(2, 3),
                3,
                new ComplexNumber(6, 9)
            )
        );
    }

    public static Stream<Arguments> getSourceForDivideWithDouble() {
        return Stream.of(
            Arguments.of(
                new ComplexNumber(4, 6),
                2,
                new ComplexNumber(2, 3)
            )
        );
    }
}