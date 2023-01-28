package dev.archie.complexnumber;

class ComplexOperations {

    static ComplexNumber add(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        return new ComplexNumber(complexNumber1.getReal() + complexNumber2.getReal(),
            complexNumber1.getImage() + complexNumber2.getImage());
    }

    static ComplexNumber add(ComplexNumber complexNumber, double toAdd) {
        return new ComplexNumber(complexNumber.getReal() + toAdd, complexNumber.getImage());
    }

    static ComplexNumber subtract(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2) {
        return new ComplexNumber(complexNumber1.getReal() - complexNumber2.getReal(),
            complexNumber1.getImage() - complexNumber2.getImage());
    }

    static ComplexNumber subtract(ComplexNumber complexNumber, double toSubtract) {
        return new ComplexNumber(complexNumber.getReal() - toSubtract, complexNumber.getImage());
    }

    static ComplexNumber multiply(ComplexNumber complexNumber1,
        ComplexNumber complexNumber2) {
        double a = complexNumber1.getReal();
        double b = complexNumber1.getImage();
        double c = complexNumber2.getReal();
        double d = complexNumber2.getImage();
        return new ComplexNumber(a * c - b * d, a * d + b * c);
    }

    static ComplexNumber multiply(ComplexNumber complexNumber, double toMultiply) {
        double a = complexNumber.getReal();
        double b = complexNumber.getImage();
        return new ComplexNumber(a * toMultiply, b * toMultiply);
    }

    static ComplexNumber divide(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        double a = complexNumber1.getReal();
        double b = complexNumber1.getImage();
        double c = complexNumber2.getReal();
        double d = complexNumber2.getImage();
        return new ComplexNumber((a * c + b * d) / (c * c + d * d),
            (b * c - a * d) / (c * c + d * d));
    }

    static ComplexNumber divide(ComplexNumber complexNumber, double toDivide) {
        double a = complexNumber.getReal();
        double b = complexNumber.getImage();
        return new ComplexNumber(a / toDivide, b / toDivide);
    }

    static double absolute(ComplexNumber complexNumber) {
        double a = complexNumber.getReal();
        double b = complexNumber.getImage();
        return Math.sqrt(a * a + b * b);
    }

    static double argument(ComplexNumber complexNumber) {
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

    static ComplexNumber negative(ComplexNumber a) {
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
