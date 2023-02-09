package dev.archie.application;

import java.util.InputMismatchException;

/**
 * Класс для обработки исключений выброшенных application
 */
public class ExceptionHandler {

    private final Application application;

    public ExceptionHandler(Application application) {
        this.application = application;
    }

    public void runApplicationWithHandling() {
        try {
            application.run();
        } catch (ArithmeticException failedDivideByZero) {
            System.out.println("You cannot divide by zero");
        } catch (IllegalArgumentException failingMultiplyMatrices) {
            System.out.println(failingMultiplyMatrices.getMessage());
        } catch (InputMismatchException failingReadComplexNumber) {
            System.out.println(
                "Failed to read complex number please type complex number in format: 1 + 2 i");
        } catch (Exception unknownException) {
            System.out.println("Unknown exception: " + unknownException.getMessage());
        } finally {
            if (application.isRunning()) {
                application.run();
            }
        }
    }
}
