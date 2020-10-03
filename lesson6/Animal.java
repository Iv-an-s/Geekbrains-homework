package lesson6;

//2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому
// методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).

public abstract class Animal {
    private String name;
    private double runLimit;
    private double jumpLimit;
    private double swimLimit;

    public Animal(String name, double runLimit, double jumpLimit, double swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }

    public void runn(double length) {
        if (length <= runLimit) {
            System.out.printf("%s %s ran %s meters %n", getClass().getSimpleName(), name, length);
        } else {
            System.out.printf("%s ran %s meters and got tired. Energy is finished.%n", getClass().getSimpleName(), name, runLimit);
        }
    }

    public void swim(double length) {
        if (length <= swimLimit) {
            System.out.printf("%s %s swam %s meters %n", getClass().getSimpleName(), name, length);
        } else {
            System.out.printf("%s %s swam %s meters and drowned. RIP.%n", getClass().getSimpleName(), name, swimLimit);
        }
    }

    public void jump(double high) {
        if (high <= jumpLimit) {
            System.out.printf("%s %s jumped %s meters high %n", getClass().getSimpleName(), name, high);
        } else {
            System.out.printf("%s %s jumped %s meters high. Jump failed.%n", getClass().getSimpleName(), name, jumpLimit);
        }
    }
}
