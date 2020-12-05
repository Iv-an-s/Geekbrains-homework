package part3.lesson5.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FuelStation {
    private GasPool gasPool;
    private Semaphore semaphore;
    private Lock lock= new ReentrantLock();

    public FuelStation() {
        gasPool = new GasPool();
        semaphore = new Semaphore(3);
    }

    public float refuel(float amount){
        try {
            lock.lock();
            semaphore.acquire();
            Thread.sleep(3500);
            float request = gasPool.request(amount); // 1500 millis here
            System.out.println(gasPool);
            lock.unlock();
            return request;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

        return 0f;
    }
}
