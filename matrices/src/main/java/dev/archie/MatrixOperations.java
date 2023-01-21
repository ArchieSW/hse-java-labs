package dev.archie;

public class MatrixOperations {

    public static final String STACK_EXCEPTION_MESSAGE = "Cannot stack matrices with different heights and widths";
    public static final String MULTIPLY_EXCEPTION_MESSAGE = "Cannot multiply matrices with different widths and heights";
    public static final String DETERMINANT_EXCEPTION_MESSAGE = "Cannot process determinant for non square matrix or matrix dimension not supported";

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
                    ComplexNumber multiplied = Operations.multiply(a.getValue(i, k),
                        b.getValue(k, j));
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

    public static ComplexNumber determinant(ComplexMatrix a) {
        if (a.getHeight() != a.getWidth() || a.getWidth() > 3) {
            throw new IllegalArgumentException(DETERMINANT_EXCEPTION_MESSAGE);
        }

        if (a.getWidth() == 1) {
            return determinantForOneDimensionMatrix(a);
        } else if (a.getWidth() == 2) {
            return determinantForTwoDimensionMatrix(a);
        } else if (a.getWidth() == 3) {
            return determinantForThreeDimensionMatrix(a);
        } else {
            throw new RuntimeException("Unreachable code");
        }
    }

    private static ComplexNumber determinantForOneDimensionMatrix(ComplexMatrix a) {
        return a.getValue(0, 0);
    }

    private static ComplexNumber determinantForTwoDimensionMatrix(ComplexMatrix a) {
        ComplexNumber aVal = a.getValue(0, 0);
        ComplexNumber b = a.getValue(1, 0);
        ComplexNumber c = a.getValue(0, 1);
        ComplexNumber d = a.getValue(1, 1);
        return Operations.subtract(Operations.multiply(aVal, d), Operations.multiply(b, c));
    }

    private static ComplexNumber determinantForThreeDimensionMatrix(ComplexMatrix a) {
        ComplexMatrix minor1 = new ComplexMatrix(a.getHeight() - 1);
        minor1.setValue(0, 0, a.getValue(1, 1)); minor1.setValue(0, 1, a.getValue(1, 2));
        minor1.setValue(1, 0, a.getValue(2, 1)); minor1.setValue(1, 1, a.getValue(2, 2));

        ComplexMatrix minor2 = new ComplexMatrix(a.getHeight() - 1);
        minor2.setValue(0, 0, a.getValue(1, 0)); minor2.setValue(0, 1, a.getValue(1, 2));
        minor2.setValue(1, 0, a.getValue(2, 0)); minor2.setValue(1, 1, a.getValue(2, 2));

        ComplexMatrix minor3 = new ComplexMatrix(a.getHeight() - 1);
        minor3.setValue(0, 0, a.getValue(1, 0)); minor3.setValue(0, 1, a.getValue(1, 1));
        minor3.setValue(1, 0, a.getValue(2, 0)); minor3.setValue(1, 1, a.getValue(2, 1));

        ComplexNumber firstTerm = Operations.multiply(a.getValue(0, 0),
            determinantForTwoDimensionMatrix(minor1));
        ComplexNumber secondTerm = Operations.negative(Operations.multiply(a.getValue(0, 1),
            determinantForTwoDimensionMatrix(minor2)));
        ComplexNumber thirdTerm = Operations.multiply(a.getValue(0, 2),
            determinantForTwoDimensionMatrix(minor3));

        return Operations.add(Operations.add(firstTerm, secondTerm), thirdTerm);
    }

}
