package dev.archie;

public class MatrixOperations {

    public static final String STACK_EXCEPTION_MESSAGE = "Cannot stack matrices with different heights and widths";
    public static final String MULTIPLY_EXCEPTION_MESSAGE = "Cannot multiply matrices with different widths and heights";

    public static ComplexMatrix add(ComplexMatrix a, ComplexMatrix b) {
        int height = a.getHeight();
        int width = a.getWidth();
        if (b.getHeight() != height || b.getWidth() != width) {
            throw new IllegalArgumentException(STACK_EXCEPTION_MESSAGE);
        }
        ComplexMatrix result = new ComplexMatrix(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ComplexNumber processedValue = Operations.add(a.getValue(i, j), b.getValue(i, j));
                result.setValue(i, j, processedValue);
            }
        }
        return result;
    }

    public static ComplexMatrix negative(ComplexMatrix a) {
        int height = a.getHeight();
        int width = a.getWidth();
        ComplexMatrix result = new ComplexMatrix(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ComplexNumber currentValue = a.getValue(i, j);
                ComplexNumber negativeValue = Operations.negative(currentValue);
                result.setValue(i, j, negativeValue);
            }
        }
        return result;
    }

    public static ComplexMatrix multiply(ComplexMatrix a, ComplexNumber b) {
        int width = a.getWidth();
        int height = a.getHeight();
        ComplexMatrix result = new ComplexMatrix(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ComplexNumber currentValue = a.getValue(i, j);
                ComplexNumber multipliedValue = Operations.multiply(currentValue, b);
                result.setValue(i, j, multipliedValue);
            }
        }
        return result;
    }

    public static ComplexMatrix multiply(ComplexMatrix a, ComplexMatrix b) {
        if (a.getWidth() != b.getHeight()) {
            throw new IllegalArgumentException(MULTIPLY_EXCEPTION_MESSAGE);
        }
        int height = a.getHeight();
        int width = b.getWidth();
        ComplexMatrix result = new ComplexMatrix(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ComplexNumber sum = new ComplexNumber();
                for (int k = 0; k < a.getWidth(); k++) {
                    ComplexNumber multiplied = Operations.multiply(a.getValue(i, k), b.getValue(k, j));
                    sum = Operations.add(sum, multiplied);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }

    public static ComplexMatrix transposition(ComplexMatrix a) {
        int width = a.getWidth();
        int height = a.getHeight();
        ComplexMatrix result = new ComplexMatrix(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result.setValue(j, i, a.getValue(i, j).clone());
            }
        }
        return result;
    }

}
