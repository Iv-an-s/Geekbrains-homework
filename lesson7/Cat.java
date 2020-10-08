package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if (p.getFood()<appetite){
            System.out.println("Not enough food");
        }else if(satiety){
            System.out.println(String.format("Cat %s is full", name));
        }else {
            p.decreaseFood(appetite);
            satiety = true;
        }
    }
}
