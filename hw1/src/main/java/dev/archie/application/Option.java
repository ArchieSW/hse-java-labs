package dev.archie.application;

import java.util.Optional;

/**
 * Опции для главного меню, обозначающии операции над комплексными матрицами
 */
enum Option {
    EXIT(1),
    MULTIPLY(2),
    ADD(3),
    DETERMINANT(4),
    TRANSPOSITION(5),
    NEGATIVE(6);

    private final int optionIndex;

    Option(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    /**
     * @return индекс опции
     */
    public int getOptionIndex() {
        return optionIndex;
    }

    /**
     * @param index индекс опции
     * @return опция
     */
    public static Optional<Option> getOptionFromIndex(int index) {
        for (Option option : Option.values()) {
            if (option.getOptionIndex() == index) {
                return Optional.of(option);
            }
        }
        return Optional.empty();
    }
}
