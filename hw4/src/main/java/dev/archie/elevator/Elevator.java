package dev.archie.elevator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Elevator implements Runnable {

    private static final long LATENCY_BETWEEN_FLOORS = 2000;
    @NotNull
    private final ConcurrentLinkedQueue<Request> requests;
    private final int index;

    private int prevLoggedFloor = Integer.MIN_VALUE;
    @NotNull
    private Direction prevLoggedDirection = Direction.STAY;

    private int currentFloor;

    @NotNull
    private Direction currentDirection;
    @Nullable
    private Request currentRequest;

    public Elevator(int index) {
        this.currentFloor = 0;
        this.currentDirection = Direction.STAY;
        this.requests = new ConcurrentLinkedQueue<>();
        this.index = index;
    }

    public void call(@NotNull Request request) {
        System.out.printf("[%d] Called with request %s%n", index, request);
        requests.add(request);
    }

    @Override
    public void run() {
        while (true) {
            tryDelayProcessing();
            updateFloor();
            updateDirection();
            move();
            log();
        }
    }

    private static void tryDelayProcessing() {
        try {
            Thread.sleep(LATENCY_BETWEEN_FLOORS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateFloor() {
        if (currentRequest == null || currentFloor == currentRequest.floor()) {
            currentRequest = getNearestFloorRequest();
        }
    }

    private void updateDirection() {
        if (currentRequest == null) {
            currentDirection = Direction.STAY;
            return;
        }
        if (currentRequest.floor() - currentFloor == 0) {
            currentDirection = Direction.STAY;
        } else if (currentRequest.floor() - currentFloor > 0) {
            currentDirection = Direction.UP;
        } else {
            currentDirection = Direction.DOWN;
        }
    }

    private void move() {
        switch (currentDirection) {
            case UP -> currentFloor++;
            case DOWN -> currentFloor--;
        }
    }

    private void log() {
        if (prevLoggedFloor == currentFloor && prevLoggedDirection == currentDirection) {
            return;
        }
        prevLoggedDirection = currentDirection;
        prevLoggedFloor = currentFloor;
        System.out.printf("[%d] Elevator at floor %d and going %s %n",
                index, currentFloor, currentDirection);
    }

    private Request getNearestFloorRequest() {
        Request nearest = null;
        for (Request request : requests) {
            int requestFloor = request.floor();
            if (nearest == null ||
                    (Math.abs(requestFloor - currentFloor) < nearest.floor())) {
                nearest = request;
            }
        }
        if (nearest != null) {
            requests.remove(nearest);
        }
        return nearest;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public @NotNull Direction getCurrentDirection() {
        return currentDirection;
    }
}
