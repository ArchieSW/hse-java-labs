package dev.archie;

import dev.archie.application.Application;
import dev.archie.application.CharacterCounter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CharacterCounter characterCounter = new CharacterCounter();
        Application application = new Application(scanner, characterCounter);
        application.run();
    }
}