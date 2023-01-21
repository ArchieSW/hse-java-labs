package dev.archie;

public class Operations {

    public static ComplexNumber add(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        return new ComplexNumber(complexNumber1.getReal() + complexNumber2.getReal(),
            complexNumber1.getImage() + complexNumber2.getImage());
    }

    public static ComplexNumber add(ComplexNumber complexNumber, double toAdd) {
        return new ComplexNumber(complexNumber.getReal() + toAdd, complexNumber.getImage());
    }

    public static ComplexNumber subtract(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2) {
        return new ComplexNumber(complexNumber1.getReal() - complexNumber2.getReal(),
            complexNumber1.getImage() - complexNumber2.getImage());
    }

    public static ComplexNumber subtract(ComplexNumber complexNumber, double toSubtract) {
        return new ComplexNumber(complexNumber.getReal() - toSubtract, complexNumber.getImage());
    }

    public static ComplexNumber multiply(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2) {
        double a = complexNumber1.getReal();
        double b = complexNumber1.getImage();
        double c = complexNumber2.getReal();
        double d = complexNumber2.getImage();
        return new ComplexNumber(a * c - b * d, a * d + b * c);
    }

    public static ComplexNumber multiply(ComplexNumber complexNumber, double toMultiply) {
        double a = complexNumber.getReal();
        double b = complexNumber.getImage();
        return new ComplexNumber(a * toMultiply, b * toMultiply);
    }

    public static ComplexNumber divide(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        double a = complexNumber1.getReal();
        double b = complexNumber1.getImage();
        double c = complexNumber2.getReal();
        double d = complexNumber2.getImage();
        return new ComplexNumber((a * c + b * d) / (c * c + d * d),
            (b * c - a * d) / (c * c + d * d));
    }

    public static ComplexNumber divide(ComplexNumber complexNumber, double toDivide) {
        double a = complexNumber.getReal();
        double b = complexNumber.getImage();
        return new ComplexNumber(a / toDivide, b / toDivide);
    }

    public static double absolute(ComplexNumber complexNumber) {
        double a = complexNumber.getReal();
        double b = complexNumber.getImage();
        return Math.sqrt(a * a + b * b);
    }

    public static double argument(ComplexNumber complexNumber) {
        double x = complexNumber.getReal();
        double y = complexNumber.getImage();
        if (x > 0) {
            return Math.atan(y / x);
        } else if (x < 0 && y >= 0) {
            return Math.PI + Math.atan(y / x);
        } else if (x < 0 && y < 0) {
            return -Math.PI + Math.atan(y / x);
        } else if (x == 0 && y > 0) {
            return Math.PI / 2;
        } else {
            return -Math.PI / 2;
        }
    }

    public static ComplexNumber negative(ComplexNumber a) {
        double real = a.getReal();
        double image = a.getImage();
        if (real == 0.0) {
            real = -0.0;
        }
        if (image == 0.0) {
            image = -0.0;
        }
        return new ComplexNumber(-real, -image);
    }

}
