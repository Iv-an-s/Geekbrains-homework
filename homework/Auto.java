package part3.lesson5.homework;

import java.util.Date;

public abstract class Auto implements Runnable{
    private float tankCapacity;
    private float fuelReserve;
    private float consumption;
    private String regNumber;
    private FuelStation fuelStation;


    public Auto(float tankCapacity, float fuelReserve, float consumption, String regNumber, FuelStation fuelStation) {
        this.tankCapacity = tankCapacity;
        this.fuelReserve = fuelReserve;
        this.consumption = consumption;
        this.regNumber = regNumber;
        this.fuelStation = fuelStation;
    }

    public void drive() {
        System.out.println(String.format("[%s] is on the road..", regNumber));
        try {
            while (fuelReserve >= consumption) {
                Thread.sleep(3000);
                fuelReserve -= consumption;
                System.out.println(String.format("[%s]'s remaining fuel is %s", regNumber, fuelReserve));
            }
            System.out.println(String.format("[%s] has no enough fuel", regNumber));
            float requestedFuelAmount = tankCapacity-fuelReserve;
            System.out.println(String.format("[%s] is trying to refuel", regNumber));
            float refuel = fuelStation.refuel(requestedFuelAmount);
            if (refuel == 0f){
                System.out.println(String.format("[%s] is stuck without fuel...", regNumber));
                return;
            }
            fuelReserve +=refuel;
            System.out.println(String.format("[%s] has just refueled successfully", regNumber));
            drive();
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void run() {
        drive();
    }
}
