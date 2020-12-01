package part3.lesson4.homework;

public class ThreadC implements Runnable {
    private ABC abc;

    public ThreadC(ABC abc) {
        this.abc = abc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            abc.printC();
        }
    }
}
