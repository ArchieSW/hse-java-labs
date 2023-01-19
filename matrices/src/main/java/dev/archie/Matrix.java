package dev.archie;

public class Matrix {

    private final ComplexNumber[][] matrix;
    private final int height;
    private final int width;

    public Matrix(int height, int width) {
        matrix = new ComplexNumber[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                matrix[i][j] = new ComplexNumber();
            }
        }
        this.height = height;
        this.width = width;
    }

    public Matrix(int height) {
        this(height, height);
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
        matrix[i][j] = value.clone();
    }
}
