package part2.lesson5;

import java.util.Arrays;

public class SeparateCalculation implements Runnable {
    private float[] arr;

    public float[] getArr() {
        return arr;
    }

    public SeparateCalculation(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
