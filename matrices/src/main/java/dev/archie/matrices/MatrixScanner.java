package dev.archie.matrices;

import dev.archie.complexnumber.ComplexScanner;
import java.util.Scanner;

public class MatrixScanner {

    private final Scanner scanner;

    public MatrixScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ComplexMatrix nextMatrix(int height, int width) {
        ComplexScanner complexScanner = new ComplexScanner(scanner);
        ComplexMatrix complexMatrix = new ComplexMatrix(height, width);
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                complexMatrix.setValue(i, j, complexScanner.nextComplex());
            }
        }
        return complexMatrix;
    }
}
