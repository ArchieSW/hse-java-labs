package dev.archie;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserDataProcessor {
    public String processUserData(String input) {
        String[] data = input.split(" ");
        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        LocalDate birthDate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String initials = name.charAt(0) + "." + patronymic.charAt(0) + ".";
        String gender = (patronymic.charAt(patronymic.length() - 1) == 'ч') ? "М" : "Ж";
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        String ageSuffix = getAgeSuffix(age);
        return String.format("%s %s %s %d %s", surname, initials, gender, age, ageSuffix);
    }

    public String getAgeSuffix(int age) {
        if (isSingleYear(age)) {
            return "год";
        } else if (isFewYears(age)) {
            return "года";
        } else {
            return "лет";
        }
    }

    private boolean isSingleYear(int age) {
        return age % 10 == 1 && age != 11;
    }

    private boolean isFewYears(int age) {
        return age % 10 >= 2 && age % 10 <= 4 && !(age >= 12 && age <= 14);
    }
}