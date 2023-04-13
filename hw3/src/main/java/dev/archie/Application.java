package dev.archie;

import java.util.Scanner;

public class Application {
    private final Scanner inputReader;
    private final UserDataProcessor userDataProcessor;

    public Application(Scanner inputReader, UserDataProcessor userDataProcessor) {
        this.inputReader = inputReader;
        this.userDataProcessor = userDataProcessor;
    }

    public void run() {
        System.out.println("Введите фамилию, имя, отчество и дату рождения через пробел (например, Иванов Иван Иванович 15.01.1990): ");
        String input = inputReader.nextLine();
        String result = userDataProcessor.processUserData(input);
        System.out.println(result);
    }

}