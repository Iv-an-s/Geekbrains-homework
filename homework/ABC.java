package part3.lesson4.homework;

public class ABC {
    private boolean isA = false;
    private boolean isB = false;
    private boolean isC = true; // false - не напечатана последней, true - напечатана последней

    public synchronized void printA(){
        while (!isC){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isA = true;
        isC = false;
        System.out.print("A");
        notifyAll();
    }

    public synchronized void printB(){
        while (!isA){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        isB = true;
        isA = false;
        System.out.print("B");
        notifyAll();
    }

    public synchronized void printC(){
        while (!isB){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isC = true;
        isB = false;
        System.out.print("C");
        notifyAll();
    }
}
