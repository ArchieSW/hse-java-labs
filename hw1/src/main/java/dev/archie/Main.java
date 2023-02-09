package dev.archie;

import dev.archie.application.Application;
import dev.archie.application.ExceptionHandler;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(scanner);
        ExceptionHandler exceptionHandler = new ExceptionHandler(application);
        exceptionHandler.runApplicationWithHandling();
    }
}