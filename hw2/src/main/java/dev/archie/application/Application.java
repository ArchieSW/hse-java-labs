package dev.archie.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Класс приложения
 */
public class Application {

    private final Scanner scanner;
    private final CharacterCounter characterCounter;

    /**
     * @param scanner          для считывания имени файла от пользователя
     * @param characterCounter для подсчета количества
     */
    public Application(Scanner scanner, CharacterCounter characterCounter) {
        this.scanner = scanner;
        this.characterCounter = characterCounter;
    }

    /**
     * Запуск приложения
     */
    public void run() {
        String inputFileName = askUserForFileName();
        InputStream inputStream = getInputStream(inputFileName);
        Scanner fileScanner = new Scanner(inputStream);
        Map<Character, Integer> frequency = characterCounter.process(fileScanner);
        String outputFileName = askUserForFileName();
        writeFrequency(frequency, outputFileName);
    }

    private void writeFrequency(Map<Character, Integer> frequency, String outputFileName) {
        try (OutputStream outputStream = new FileOutputStream(outputFileName)) {
            outputStream.write(mapToString(frequency).getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Failed to write to file");
        }
    }

    private String mapToString(Map<?, ?> map) {
        return map.entrySet().stream()
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(Collectors.joining(",", "{", "}"));
    }

    private String askUserForFileName() {
        System.out.println("Enter filename:");
        return scanner.nextLine().trim();
    }

    private InputStream getInputStream(String fileName) {
        File file = new File(fileName);
        try (InputStream inputStream = new FileInputStream(file)) {
            return inputStream;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read from file");
        }
    }

}
