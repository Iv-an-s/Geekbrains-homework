package lesson7;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random random = new Random();
        int numberOfCats = random.nextInt(8)+2;
        Cat [] cats = new Cat[numberOfCats];
        for (int i = 0; i < cats.length; i++){
            cats[i] = new Cat("Cat-"+i, random.nextInt(5)+5);
        }

        Plate plate = new Plate(30);

        for (Cat cat: cats){
            System.out.println(cat.getName() + "'s appetite is: " + cat.getAppetite());
            cat.eat(plate);
            System.out.println(cat.getName() + " is full: " + cat.isSatiety());
            plate.info();
        }
    }
}
