package dev.archie.application;

import static dev.archie.application.Option.EXIT;

import dev.archie.matrices.ComplexMatrix;
import dev.archie.matrices.MatrixScanner;
import java.util.Scanner;

/**
 * Класс консольного приложения, показывающее главное меню с опциями для работы с комплексными
 * числами
 */
public class Application {

    private final Scanner scanner;
    private final MatrixScanner matrixScanner;
    private boolean isRunning = false;

    /**
     * @param scanner сканнер для ввода данных
     */
    public Application(Scanner scanner) {
        this.scanner = scanner;
        this.matrixScanner = new MatrixScanner(scanner);
    }

    /**
     * Запуск приложения в бесконечном цикле (для остановки требуется ввести 1 из главного меню)
     */
    public void run() {
        isRunning = true;
        while (isRunning) {
            printMainMenu();
            int choosedOption = scanner.nextInt();
            if (choosedOption == EXIT.getOptionIndex()) {
                System.out.println("Goodbye!");
                isRunning = false;
                break;
            }
            processOption(choosedOption);
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    private static void printMainMenu() {
        System.out.println("Main Menu");
        for (Option option : Option.values()) {
            System.out.println(option.toString() + ":\t" + option.getOptionIndex());
        }
        System.out.print("Type option which you want: ");
    }

    private void processOption(int choosedOption) {
        Option option = Option.getOptionFromIndex(choosedOption)
            .orElseThrow(() -> new RuntimeException(
                "No such option with index " + choosedOption + ". Please choose correect option."));
        processOption(option);
    }

    private void processOption(Option option) {
        switch (option) {
            case MULTIPLY -> processMultiply();
            case ADD -> processAdd();
            case DETERMINANT -> processDeterminant();
            case TRANSPOSITION -> processTransposition();
            case NEGATIVE -> processNegative();
        }
    }

    private void processMultiply() {
        ComplexMatrix complexMatrix1 = askUserForMatrix();
        ComplexMatrix complexMatrix2 = askUserForMatrix();
        System.out.println("Result:");
        System.out.println(complexMatrix1.multiply(complexMatrix2));
    }

    private ComplexMatrix askUserForMatrix() {
        System.out.println("Enter matrix dimensions <in format: height width>:");
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        System.out.println("Enter matrix <in format: 1 + 0 i 2 + 1 i>:");
        return matrixScanner.nextMatrix(height, width);
    }

    private void processAdd() {
        ComplexMatrix complexMatrix1 = askUserForMatrix();
        ComplexMatrix complexMatrix2 = askUserForMatrix();
        System.out.println("Result:");
        System.out.println(complexMatrix1.add(complexMatrix2));
    }

    private void processDeterminant() {
        ComplexMatrix complexMatrix = askUserForMatrix();
        System.out.println("Result:");
        System.out.println(complexMatrix.determinant());
    }

    private void processTransposition() {
        ComplexMatrix complexMatrix = askUserForMatrix();
        System.out.println("Result:");
        System.out.println(complexMatrix.transposition());
    }

    private void processNegative() {
        ComplexMatrix complexMatrix = askUserForMatrix();
        System.out.println("Result:");
        System.out.println(complexMatrix.negative());
    }
}