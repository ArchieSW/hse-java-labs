package dev.archie.elevator;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RequestGenerator implements Runnable {

    private static final int MIN_FLOOR = 0;
    private static final int MAX_FLOOR = 10;
    private static final int MAX_LATENCY = 7;
    private static final int MIN_LATENCY = 3;
    @NotNull
    private final Random random = new Random();
    @NotNull
    private final ElevatorController elevatorController;
    public int latencyBetweenRequests;

    public RequestGenerator(@NotNull ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    @Override
    public void run() {
        while (true) {
            tryDelayRequests();
            Request request = getRandomRequest();
            log(request);
            requestElevators(request);
        }
    }

    private void requestElevators(Request request) {
        elevatorController.call(request);
    }

    private void tryDelayRequests() {
        try {
            latencyBetweenRequests = getRandomLatency();
            Thread.sleep(latencyBetweenRequests * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Request getRandomRequest() {
        int randomFloor = getRandomFloor();
        Direction randomDirection = getRandomDirection();
        return new Request(randomFloor, randomDirection);
    }

    private int getRandomLatency() {
        return random.nextInt(MAX_LATENCY - MIN_LATENCY) + MIN_LATENCY;
    }

    private void log(Request request) {
        System.out.printf("[%s] Generated request %s%n",
                Thread.currentThread().getName(), request);
    }

    private int getRandomFloor() {
        return random.nextInt(MAX_FLOOR - MIN_FLOOR + 1) + MIN_FLOOR;
    }

    private Direction getRandomDirection() {
        int randomValue = this.random.nextInt(2);
        if (randomValue == 0) {
            return Direction.UP;
        }
        return Direction.DOWN;
    }
}
