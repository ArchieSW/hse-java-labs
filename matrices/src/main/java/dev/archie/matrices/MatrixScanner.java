package dev.archie.matrices;

import dev.archie.complexnumber.ComplexScanner;
import java.util.Scanner;

/**
 * Класс для считывания матрицы со сканнера
 */
public class MatrixScanner {

    public static final String ILLEGAL_DIMENSIONS_MESSAGE = "Cannot read matrix with non positive dimensions";
    private final Scanner scanner;

    /**
     * @param scanner для считывания матрицы
     */
    public MatrixScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @param height высота матрицы
     * @param width  ширина матрицы
     * @return матрицы считанная со сканнера
     */
    public ComplexMatrix nextMatrix(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(ILLEGAL_DIMENSIONS_MESSAGE);
        }
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
