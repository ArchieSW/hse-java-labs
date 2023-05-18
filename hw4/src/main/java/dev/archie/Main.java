package dev.archie;


import dev.archie.elevator.Elevator;
import dev.archie.elevator.ElevatorController;
import dev.archie.elevator.RequestGenerator;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Elevator> elevators = List.of(new Elevator(1), new Elevator(2));
        ElevatorController elevatorController = new ElevatorController(elevators);
        RequestGenerator requestGenerator = new RequestGenerator(elevatorController);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        elevators.forEach(executorService::execute);
        executorService.execute(requestGenerator);
    }
}