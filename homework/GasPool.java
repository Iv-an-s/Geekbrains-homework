package part3.lesson5.homework;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final float maxFuelCapacity = 200f;
    private float fuelReserve = 200f;

    public float request(float amount){
        lock.writeLock().lock();
            try {
                if (fuelReserve >= amount) {
                    Thread.sleep(1500);
                    fuelReserve -= amount;
                    return amount;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();
            }
        System.out.println("There is no enough fuel in GazPool");
        return 0f;
    }

    public String info(){
        System.out.println(String.format("Fuel reserve is: %s", maxFuelCapacity));
        return toString();
    }

    @Override
    public String toString() {
        return "GasPool{" +
                "maxFuelCapacity=" + maxFuelCapacity +
                ", fuelReserve=" + fuelReserve +
                '}';
    }
}
