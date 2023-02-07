package dev.archie.complexnumber;

import java.util.Objects;

/**
 * ComplexNumber - класс для работы с комплексными числами
 */
public class ComplexNumber {

    private final double real;
    private final double image;

    /**
     * @param real действительная часть комплексного числа
     * @param image мнимая часть комплексного числа
     */
    public ComplexNumber(double real, double image) {
        this.image = image;
        this.real = real;
    }

    /**
     * @param real действительная часть комплексного числа
     */
    public ComplexNumber(double real) {
        this(real, 0);
    }

    /**
     * Конструктор по умолчанию.
     * Создает комплексное число 0 + 0i
     */
    public ComplexNumber() {
        this(0, 0);
    }

    /**
     * Конструктор копирования
     * @param toCopy копируемое комплексное число
     */
    public ComplexNumber(ComplexNumber toCopy) {
        this(toCopy.getReal(), toCopy.getImage());
    }

    /**
     * @return мнимая часть комплексного числа
     */
    public double getImage() {
        return image;
    }

    /**
     * @return реальная часть комплексного числа
     */
    public double getReal() {
        return real;
    }

    /**
     * @return строка алгебраической формы комплексного числа.
     */
    public String getAlgebraicForm() {
        return toString();
    }

    /**
     * @return строка тригонометрической формы комплексного числа
     */
    public String getTrigonometricForm() {
        double r = ComplexOperations.absolute(this);
        double phi = ComplexOperations.argument(this);
        return String.format("%f(cos(%f) + i * sin(%f))", r, phi, phi);
    }

    @Override
    public String toString() {
        char sign = getImageSign();
        return real + " " + sign + " " + Math.abs(image) + " i";
    }

    private char getImageSign() {
        return (Double.compare(image, 0.0) < 0) ? '-' : '+';
    }

    /**
     * @param b складываемое комплексного числа
     * @return суммарное комплексное число
     */
    public ComplexNumber add(ComplexNumber b) {
        return ComplexOperations.add(this, b);
    }

    /**
     * @param b складываемое действительное число
     * @return суммарное комплексное число
     */
    public ComplexNumber add(double b) {
        return ComplexOperations.add(this, b);
    }

    /**
     * @param b вычитаемое комплексное число
     * @return результат вычитания
     */
    public ComplexNumber subtract(ComplexNumber b) {
        return ComplexOperations.subtract(this, b);
    }

    /**
     * @param b вычитаемое действительное число
     * @return результат вычитания
     */
    public ComplexNumber subtract(double b) {
        return ComplexOperations.subtract(this, b);
    }

    /**
     * @param b множитель комплексного числа
     * @return результат умножения
     */
    public ComplexNumber multiply(ComplexNumber b) {
        return ComplexOperations.multiply(this, b);
    }

    /**
     * @param b множитель действительное число
     * @return результат умножения
     */
    public ComplexNumber multiply(double b) {
        return ComplexOperations.multiply(this, b);
    }

    /**
     * @param b делитель комплексное число
     * @return результат деления
     */
    public ComplexNumber divide(ComplexNumber b) {
        return ComplexOperations.divide(this, b);
    }

    /**
     * @param b делитель действительное число
     * @return результат деления
     */
    public ComplexNumber divide(double b) {
        return ComplexOperations.divide(this, b);
    }

    /**
     * @return модуль комплексного числа
     */
    public double absolute() {
        return ComplexOperations.absolute(this);
    }

    /**
     * @return аргумент комплексного числа
     */
    public double argument() {
        return ComplexOperations.argument(this);
    }

    /**
     * @return отрицательное комплексное число
     */
    public ComplexNumber negative() {
        return ComplexOperations.negative(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.image, image) == 0 && Double.compare(that.real, real) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, real);
    }
}
