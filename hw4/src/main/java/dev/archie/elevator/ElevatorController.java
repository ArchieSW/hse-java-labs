package dev.archie.elevator;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ElevatorController {

    @NotNull
    private final List<Elevator> elevators;

    public ElevatorController(@NotNull List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void call(@NotNull Request request) {
        getEffectiveElevator(request).call(request);
    }

    private @NotNull Elevator getEffectiveElevator(@NotNull Request request) {
        Elevator effectiveElevator = null;
        int minDifference = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int difference = request.floor() - elevator.getCurrentFloor();
            if (isOnSameDirection(elevator, difference)) {
                if (minDifference > difference) {
                    minDifference = difference;
                    effectiveElevator = elevator;
                }
            }
        }
        if (effectiveElevator == null) {
            effectiveElevator = elevators.get(0);
        }
        return effectiveElevator;
    }

    private static boolean isOnSameDirection(Elevator elevator, int difference) {
        return difference >= 0 && elevator.getCurrentDirection().isUpOrStay() ||
                difference < 0 && elevator.getCurrentDirection().isDownOrStay();
    }
}
