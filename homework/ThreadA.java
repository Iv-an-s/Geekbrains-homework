package part3.lesson4.homework;

public class ThreadA implements Runnable {
    private ABC abc;

    public ThreadA(ABC abc) {
        this.abc = abc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            abc.printA();
        }
    }
}
