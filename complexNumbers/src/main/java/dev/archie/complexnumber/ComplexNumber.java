package dev.archie.complexnumber;

import java.util.Objects;

public class ComplexNumber {

    private double real;
    private double image;

    public ComplexNumber(double real, double image) {
        this.image = image;
        this.real = real;
    }

    public ComplexNumber(double real) {
        this(real, 0);
    }

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(ComplexNumber toCopy) {
        this(toCopy.getReal(), toCopy.getImage());
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public String getAlgebraicForm() {
        return toString();
    }

    public String getTrigonometricForm() {
        double r = ComplexOperations.absolute(this);
        double phi = ComplexOperations.argument(this);
        return String.format("%f(cos(%f) + i * sin(%f))", r, phi, phi);
    }

    @Override
    public String toString() {
        char sign = getImageSign();
        return real + " " + sign +  " " + Math.abs(image) + "i";
    }

    private char getImageSign() {
        return (Double.compare(image, 0.0) < 0) ? '-' : '+';
    }

    public ComplexNumber add(ComplexNumber b) {
        return ComplexOperations.add(this, b);
    }

    public ComplexNumber add(double b) {
        return ComplexOperations.add(this, b);
    }

    public ComplexNumber subtract(ComplexNumber b) {
        return ComplexOperations.subtract(this, b);
    }

    public ComplexNumber subtract(double b) {
        return ComplexOperations.subtract(this, b);
    }

    public ComplexNumber multiply(ComplexNumber b) {
        return ComplexOperations.multiply(this, b);
    }

    public ComplexNumber multiply(double b) {
        return ComplexOperations.multiply(this, b);
    }

    public ComplexNumber divide(ComplexNumber b) {
        return ComplexOperations.divide(this, b);
    }

    public ComplexNumber divide(double b) {
        return ComplexOperations.divide(this, b);
    }

    public double absolute(ComplexNumber complexNumber) {
        return ComplexOperations.absolute(complexNumber);
    }

    public double argument(ComplexNumber complexNumber) {
        return ComplexOperations.argument(complexNumber);
    }

    public ComplexNumber negative() {
        return ComplexOperations.negative(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.image, image) == 0 && Double.compare(that.real, real) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, real);
    }
}
