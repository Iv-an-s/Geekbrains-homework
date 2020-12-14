package lesson7.homework;

public class Test2 implements Testable{
    int priority;

    public Test2() {
        this(5);
    }

    public Test2(int priority) {
        this.priority = priority;
    }


    @Test
    void doTestMethod(){
        System.out.println("doTestMethod -2 is running");
    }
}
