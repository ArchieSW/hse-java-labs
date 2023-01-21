package dev.archie;

import java.util.Objects;

public class ComplexNumber implements Cloneable {

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
        double r = Operations.absolute(this);
        double phi = Operations.argument(this);
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

    @Override
    public ComplexNumber clone() {
        try {
            return (ComplexNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
