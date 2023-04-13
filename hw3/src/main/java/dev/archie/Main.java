package dev.archie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDataProcessor userDataProcessor = new UserDataProcessor();
        Application app = new Application(new Scanner(System.in), userDataProcessor);
        app.run();
    }
}