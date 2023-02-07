package dev.archie.matrices;

import dev.archie.complexnumber.ComplexNumber;
import java.util.Arrays;
import java.util.Objects;

public class ComplexMatrix {

    private final ComplexNumber[][] matrix;
    private final int height;
    private final int width;

    public ComplexMatrix(int height, int width) {
        matrix = new ComplexNumber[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                matrix[i][j] = new ComplexNumber();
            }
        }
        this.height = height;
        this.width = width;
    }

    public ComplexMatrix(int height) {
        this(height, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComplexMatrix that = (ComplexMatrix) o;
        return height == that.height && width == that.width && Arrays.deepEquals(matrix,
            that.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(height, width);
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ComplexNumber[] row : matrix) {
            for (ComplexNumber currentNumber : row) {
                result.append(currentNumber.toString()).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ComplexNumber getValue(int i, int j) {
        return matrix[i][j];
    }

    public void setValue(int i, int j, ComplexNumber value) {
        matrix[i][j] = new ComplexNumber(value);
    }

    public ComplexMatrix add(ComplexMatrix toAdd) {
        return MatrixOperations.add(this, toAdd);
    }

    public ComplexMatrix negative() {
        return MatrixOperations.negative(this);
    }

    public ComplexMatrix multiply(ComplexMatrix toMultiply) {
        return MatrixOperations.multiply(this, toMultiply);
    }

    public ComplexMatrix multiply(ComplexNumber toMultiply) {
        return MatrixOperations.multiply(this, toMultiply);
    }

    public ComplexMatrix transposition() {
        return MatrixOperations.transposition(this);
    }

    public ComplexNumber determinant() {
        return MatrixOperations.determinant(this);
    }

}
