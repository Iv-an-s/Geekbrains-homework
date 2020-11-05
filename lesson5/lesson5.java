package part2.lesson5;

import java.util.Arrays;

public class lesson5 {
    static final int size = 10000000;
    static final int h = size/2;

    public static void main(String[] args) {
        modifyArray(size);
        modifyArrayWithDividing(size);
    }

    public static void modifyArray(int size){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One array. Time is: " + (System.currentTimeMillis()-a));
    }

    public static void modifyArrayWithDividing(int size){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
            float[] firstHalf = new float[arr.length/2];
            System.arraycopy(arr, 0, firstHalf, 0, firstHalf.length);
            float[] secondHalf = new float[arr.length - firstHalf.length];
            System.arraycopy(arr, firstHalf.length, secondHalf, 0, secondHalf.length);
            SeparateCalculation first = new SeparateCalculation(firstHalf);
            SeparateCalculation second = new SeparateCalculation(secondHalf);
                Thread thread1 = new Thread(first);
                Thread thread2 = new Thread(second);
                    thread1.start();
                    thread2.start();
                    try {
                        thread1.join();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    try {
                    thread2.join();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
            firstHalf = first.getArr();
            secondHalf = second.getArr();
            System.arraycopy(firstHalf, 0, arr, 0, firstHalf.length);
            System.arraycopy(secondHalf, 0, arr, firstHalf.length, secondHalf.length);

        System.out.println("Dividing into 2 arrays. Time is: " + (System.currentTimeMillis()-a));
    }
}
