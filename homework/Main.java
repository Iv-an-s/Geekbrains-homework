package part3.lesson5.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new Car("C-1", fuelStation));
        executorService.submit(new Bus("B-1", fuelStation));
        executorService.submit(new Truck("T-1", fuelStation));
        executorService.submit(new Car("C-2", fuelStation));
        executorService.submit(new Bus("B-2", fuelStation));
        executorService.submit(new Truck("T-2", fuelStation));
        executorService.submit(new Car("C-3", fuelStation));
        executorService.submit(new Bus("B-3", fuelStation));
        executorService.submit(new Truck("T-3", fuelStation));
        executorService.submit(new Car("C-4", fuelStation));

        executorService.shutdown();
    }
}
