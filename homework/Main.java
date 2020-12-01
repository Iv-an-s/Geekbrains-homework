package part3.lesson4.homework;

public class Main {
    public static void main(String[] args) {

    ABC abc = new ABC();

    Thread threadA = new Thread(new ThreadA(abc));
    Thread threadB = new Thread(new ThreadB(abc));
    Thread threadC = new Thread(new ThreadC(abc));

    threadA.start();
    threadB.start();
    threadC.start();

    }
}
