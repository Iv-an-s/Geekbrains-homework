package lesson7.homework;

public class Test1 implements Testable{

    @BeforeSuite
    void doStartMethod(){
        System.out.println("Execution of doStartMethod with BeforeSuite annotation");
    }

    @Test(priority = 5)
    void doTestMethod1(){
        System.out.println("doTestMethod1 is running");
    }

    @Test(priority = 7)
    void doTestMethod2(){
        System.out.println("doTestMethod2 is running");
    }

    @Test
    void doTestMethod3(){
        System.out.println("doTestMethod3 is running");
    }

    @AfterSuite
    void doCloseMethod(){
        System.out.println("doCloseMethod is started");
    }
}
