package dev.archie.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCounter {

    /**
     * @param scanner для считывания количества элементов
     * @return итоговая карта частотностей
     */
    public Map<Character, Integer> process(Scanner scanner) {
        Map<Character, Integer> frequency = new HashMap<>();
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            for (char currentCharacter : currentLine.toCharArray()) {
                if (!Character.isAlphabetic(currentCharacter)) {
                    continue;
                }
                int currentFrequency = frequency.getOrDefault(currentCharacter, 0);
                frequency.put(currentCharacter, currentFrequency + 1);
            }
        }
        return frequency;
    }

}
