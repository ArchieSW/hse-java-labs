package dev.archie.complexnumber;

import java.util.Scanner;

/**
 * ComplexScanner - класс для чтения комплексных чисел со сканера.
 */
public class ComplexScanner {

    private final Scanner scanner;

    /**
     * @param scanner для считываниея
     */
    public ComplexScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return считанное со сканнера комплексное число
     */
    public ComplexNumber nextComplex() {
        double real = scanner.nextDouble();
        char sign = scanner.next().charAt(0);
        double image = scanner.nextDouble();
        if (sign == '-') {
            image = -image;
        }
        char complexChar = scanner.next().charAt(0);
        return new ComplexNumber(real, image);
    }
}
