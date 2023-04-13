package dev.archie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UserDataProcessorTest {


    @ParameterizedTest
    @MethodSource("getAgeSuffixTestCases")
    void getAgeSuffix(String expected, int age) {
        Assertions.assertEquals(expected, new UserDataProcessor().getAgeSuffix(age));
    }

    public static Stream<Arguments> getAgeSuffixTestCases() {
        return Stream.of(
                Arguments.of("год", 1),
                Arguments.of("года", 2),
                Arguments.of("года", 3),
                Arguments.of("года", 4),
                Arguments.of("лет", 5),
                Arguments.of("лет", 6),
                Arguments.of("лет", 7),
                Arguments.of("лет", 8),
                Arguments.of("лет", 9),
                Arguments.of("лет", 10),
                Arguments.of("лет", 11),
                Arguments.of("лет", 12),
                Arguments.of("лет", 13),
                Arguments.of("лет", 14),
                Arguments.of("лет", 15),
                Arguments.of("лет", 16),
                Arguments.of("лет", 17),
                Arguments.of("лет", 18),
                Arguments.of("лет", 19),
                Arguments.of("лет", 20),
                Arguments.of("год", 21),
                Arguments.of("года", 22),
                Arguments.of("года", 23),
                Arguments.of("года", 24),
                Arguments.of("лет", 25),
                Arguments.of("лет", 26),
                Arguments.of("лет", 27),
                Arguments.of("лет", 28),
                Arguments.of("лет", 29),
                Arguments.of("лет", 30),
                Arguments.of("лет", 30),
                Arguments.of("год", 31),
                Arguments.of("года", 32),
                Arguments.of("года", 33),
                Arguments.of("года", 34),
                Arguments.of("лет", 35)
        );
    }

}