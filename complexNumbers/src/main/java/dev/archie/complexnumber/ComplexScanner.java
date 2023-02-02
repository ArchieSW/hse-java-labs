package dev.archie.complexnumber;

import java.util.Scanner;

public class ComplexScanner {

    private final Scanner scanner;

    public ComplexScanner(Scanner scanner) {
        this.scanner = scanner;
    }

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
