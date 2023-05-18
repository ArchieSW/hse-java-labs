package dev.archie.elevator;

public enum Direction {
    UP, DOWN, STAY;

    public boolean isUpOrStay() {
        return this == UP || this == STAY;
    }

    public boolean isDownOrStay() {
        return this == DOWN || this == STAY;
    }
}