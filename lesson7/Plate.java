package lesson7;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }
    public void info() {
        System.out.println("plate: " + food);
    }
    public void addFood(int n){
        food +=n;
    }
}
