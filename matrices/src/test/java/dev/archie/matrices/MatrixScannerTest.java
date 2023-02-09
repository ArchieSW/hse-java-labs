package dev.archie.matrices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.archie.complexnumber.ComplexNumber;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixScannerTest {

    @ParameterizedTest
    @MethodSource("getSourceForMatrixScanner")
    void nextMatrixShouldReturnCorrectMatrix(Scanner scanner, int height, int width,
        ComplexMatrix expected) {
        MatrixScanner matrixScanner = new MatrixScanner(scanner);
        ComplexMatrix actual = matrixScanner.nextMatrix(height, width);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getSourceForIllegalMatrices")
    void nextMatrixShouldThrowOnNonPositiveDimensions(Scanner scanner, int height, int width)  {
        MatrixScanner matrixScanner = new MatrixScanner(scanner);
        IllegalArgumentException illegalArgumentException = assertThrows(
            IllegalArgumentException.class, () -> {
                matrixScanner.nextMatrix(height, width);
            });
        assertEquals(MatrixScanner.ILLEGAL_DIMENSIONS_MESSAGE, illegalArgumentException.getMessage());
    }

    public static Stream<Arguments> getSourceForMatrixScanner() {
        ComplexMatrix complexMatrixTwoByTwo = new ComplexMatrix(2, 2);
        complexMatrixTwoByTwo.setValue(0, 0, new ComplexNumber(2, 3));
        complexMatrixTwoByTwo.setValue(1, 0, new ComplexNumber(4, 2));
        complexMatrixTwoByTwo.setValue(0, 1, new ComplexNumber(3, 2));
        complexMatrixTwoByTwo.setValue(1, 1, new ComplexNumber(3, 1));

        ComplexMatrix complexMatrixThreeByTwo = new ComplexMatrix(3, 2);
        complexMatrixThreeByTwo.setValue(0, 0, new ComplexNumber(0, 0));
        complexMatrixThreeByTwo.setValue(0, 1, new ComplexNumber(0, 1));
        complexMatrixThreeByTwo.setValue(1, 0, new ComplexNumber(1, 1));
        complexMatrixThreeByTwo.setValue(1, 1, new ComplexNumber(1, 2));
        complexMatrixThreeByTwo.setValue(2, 0, new ComplexNumber(2, 2));
        complexMatrixThreeByTwo.setValue(2, 1, new ComplexNumber(2, 3));

        List<ComplexMatrix> matrices = List.of(complexMatrixTwoByTwo, complexMatrixThreeByTwo);

        return matrices.stream()
            .map((matrix) -> Arguments.of(matrix.toString(), matrix.getHeight(), matrix.getWidth(),
                matrix));
    }

    public static Stream<Arguments> getSourceForIllegalMatrices() {
        return Stream.of(
            Arguments.of(
                new Scanner(" "), -1, 12
            ),
            Arguments.of(
                new Scanner(" "), 12, -1
            ),
            Arguments.of(
                new Scanner(" "), 0, 12
            ),
            Arguments.of(
                new Scanner(" "), 10, 0
            )
        );
    }
}