package dev.archie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixOperationsTest {

    private static ComplexMatrix a;
    private static ComplexMatrix b;

    @BeforeEach
    void setUp() {
        a = new ComplexMatrix(2, 2);
        b = new ComplexMatrix(2, 2);
    }

    @ParameterizedTest
    @MethodSource("getSourceForAdd")
    void addShouldAddNullMatrixCorrectly(ComplexMatrix a, ComplexMatrix b, ComplexMatrix expected) {
        ComplexMatrix actual = MatrixOperations.add(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void addShouldThrowIfArgumentsAreIllegal() {
        ComplexMatrix a = new ComplexMatrix(1, 2);
        ComplexMatrix b = new ComplexMatrix(2, 1);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> {
                MatrixOperations.add(a, b);
            });
        assertTrue(exception.getMessage()
            .contains(MatrixOperations.STACK_EXCEPTION_MESSAGE));
    }

    @Test
    void addShouldAddMatrixCorrectly() {
        a.setValue(0, 0, new ComplexNumber(1));
        a.setValue(1, 1, new ComplexNumber(1));

        b.setValue(0, 1, new ComplexNumber(1));
        b.setValue(1, 0, new ComplexNumber(1));

        ComplexMatrix actual = MatrixOperations.add(a, b);
        ComplexMatrix expected = new ComplexMatrix(2, 2);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                expected.setValue(i, j, new ComplexNumber(1));
            }
        }

        assertEquals(expected, actual);
    }

    @Test
    void negativeShouldReturnCorrectZeroMatrix() {
        ComplexMatrix actual = MatrixOperations.negative(a);
        ComplexMatrix expected = b;
        assertEquals(expected, actual);
    }

    @Test
    void negativeShouldReturnCorrectMatrix() {
        a.setValue(0, 0, new ComplexNumber(1));
        a.setValue(1, 1, new ComplexNumber(2));
        ComplexMatrix actual = MatrixOperations.negative(a);
        b.setValue(0, 0, new ComplexNumber(-1));
        b.setValue(1, 1, new ComplexNumber(-2));
        ComplexMatrix expected = b;

        assertEquals(expected, actual);
    }

    @Test
    void multiplyByComplexNumberShouldReturnCorrectMatrix() {
        a.setValue(0, 0, new ComplexNumber(1));
        a.setValue(1, 1, new ComplexNumber(2));
        ComplexNumber factor = new ComplexNumber(2);
        ComplexMatrix actual = MatrixOperations.multiply(a, factor);

        b.setValue(0, 0, new ComplexNumber(2));
        b.setValue(1, 1, new ComplexNumber(4));
        ComplexMatrix expected = b;

        assertEquals(expected, actual);
    }

    @Test
    void multiplyReturnCorrectMultipliedMatrixWhenMultipliedByIdentityMatrix() {
        a.setValue(0, 0, new ComplexNumber(1));
        a.setValue(1, 1, new ComplexNumber(1));
        b.setValue(0, 1, new ComplexNumber(2));
        b.setValue(1, 1, new ComplexNumber(2));
        ComplexMatrix actual = MatrixOperations.multiply(a, b);
        assertEquals(b, actual);
    }

    @Test
    void multiplyReturnCorrectMultipliedMatrix() {
        a.setValue(0, 1, new ComplexNumber(1));
        a.setValue(1, 1, new ComplexNumber(1));
        b.setValue(0, 1, new ComplexNumber(2));
        b.setValue(1, 1, new ComplexNumber(2));
        ComplexMatrix actual = MatrixOperations.multiply(a, b);
        assertEquals(b, actual);
    }

    @Test
    void multiplyShouldThrowWithIllegalArguments() {
        ComplexMatrix a = new ComplexMatrix(2, 3);
        ComplexMatrix b = new ComplexMatrix(4, 2);
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> {
                MatrixOperations.multiply(a, b);
            });
        assertTrue(exception.getMessage().contains(MatrixOperations.MULTIPLY_EXCEPTION_MESSAGE));
    }

    @Test
    void transpositionShouldReturnMatrixWithRotatedWidthAndHeight() {
        ComplexMatrix a = new ComplexMatrix(2, 3);
        ComplexMatrix transposed = MatrixOperations.transposition(a);
        assertEquals(a.getWidth(), transposed.getHeight());
        assertEquals(a.getHeight(), transposed.getWidth());
    }

    @Test
    void transpositionShouldReturnRotatedMatrix() {
        a.setValue(0, 1, new ComplexNumber(1));
        a.setValue(1, 1, new ComplexNumber(1));
        ComplexMatrix actual = MatrixOperations.transposition(a);
        b.setValue(1, 1, new ComplexNumber(1));
        b.setValue(1, 0, new ComplexNumber(1));
        ComplexMatrix expected = b;
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getSourceForAdd() {
        return Stream.of(
            Arguments.of(
                new ComplexMatrix(2, 2),
                new ComplexMatrix(2, 2),
                new ComplexMatrix(2, 2)
            ),
            Arguments.of(
                new ComplexMatrix(3, 3),
                new ComplexMatrix(3, 3),
                new ComplexMatrix(3, 3)
            )
        );
    }
}