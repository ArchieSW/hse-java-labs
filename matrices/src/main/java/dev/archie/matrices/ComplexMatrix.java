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
        return "ComplexMatrix{" +
            "matrix=" + Arrays.deepToString(matrix) +
            ", height=" + height +
            ", width=" + width +
            '}';
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
}