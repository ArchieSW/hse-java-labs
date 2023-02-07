package dev.archie.application;

import dev.archie.matrices.ComplexMatrix;
import java.util.Scanner;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

    public static final String FORMAT_FOR_MULTIPLY_OPTION =
        Option.MULTIPLY.getOptionIndex() + "\n"
            + "%d %d\n"
            + "%s\n"
            + "%d %d\n"
            + "%s\n"
            + Option.EXIT.getOptionIndex();

    public static final String FORMAT_FOR_ADD_OPTION =
        Option.ADD.getOptionIndex() + "\n"
            + "%d %d\n"
            + "%s\n"
            + "%d %d\n"
            + "%s\n"
            + Option.EXIT.getOptionIndex();

    public static final String FORMAT_FOR_DETERMINANT_OPTION =
        Option.DETERMINANT.getOptionIndex() + "\n"
            + "%d %d\n"
            + "%s\n"
            + Option.EXIT.getOptionIndex();

    public static final String FORMAT_FOR_TRANSPOSITION_OPTION =
        Option.TRANSPOSITION.getOptionIndex() + "\n"
            + "%d %d\n"
            + "%s\n"
            + Option.EXIT.getOptionIndex();

    public static final String FORMAT_FOR_NEGATIVE_OPTION =
        Option.NEGATIVE.getOptionIndex() + "\n"
            + "%d %d\n"
            + "%s\n"
            + Option.EXIT.getOptionIndex();

    @ParameterizedTest
    @MethodSource("getSourceForApplicationTest")
    void runShouldNotThrowForCorrectInput(Scanner inputScanner) {
        Application application = new Application(inputScanner);
        application.run();
    }

    public static Stream<Arguments> getSourceForApplicationTest() {
        ComplexMatrix complexMatrix1 = new ComplexMatrix(2, 1);
        ComplexMatrix complexMatrix2 = new ComplexMatrix(1, 2);
        ComplexMatrix complexMatrix3 = new ComplexMatrix(2, 1);
        ComplexMatrix complexMatrix4 = new ComplexMatrix(3, 3);

        return Stream.of(
            Arguments.of(
                new Scanner(String.valueOf(Option.EXIT.getOptionIndex()))
            ),
            Arguments.of(
                new Scanner(String.format(FORMAT_FOR_MULTIPLY_OPTION, complexMatrix1.getHeight(),
                    complexMatrix1.getWidth(), complexMatrix1,
                    complexMatrix2.getHeight(), complexMatrix2.getWidth(), complexMatrix2))
            ),
            Arguments.of(
                new Scanner(String.format(FORMAT_FOR_ADD_OPTION, complexMatrix1.getHeight(),
                    complexMatrix1.getWidth(), complexMatrix1,
                    complexMatrix3.getHeight(), complexMatrix3.getWidth(), complexMatrix3))
            ),
            Arguments.of(
                new Scanner(String.format(FORMAT_FOR_DETERMINANT_OPTION, complexMatrix4.getHeight(),
                    complexMatrix4.getWidth(), complexMatrix4))
            ),
            Arguments.of(
                new Scanner(
                    String.format(FORMAT_FOR_TRANSPOSITION_OPTION, complexMatrix1.getHeight(),
                        complexMatrix1.getWidth(), complexMatrix1))
            ),
            Arguments.of(
                new Scanner(String.format(FORMAT_FOR_NEGATIVE_OPTION, complexMatrix1.getHeight(),
                    complexMatrix1.getWidth(), complexMatrix1))
            )
        );
    }
}