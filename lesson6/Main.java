package lesson6;

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
// прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", 200, 2, 0);
        cat1.runn(300);

        Dog dog1 = new Dog ("Bobik",500, 0.5, 10);
        dog1.jump(1);
        Dog dog2 = new Dog ("Sharik", 600, 1, 5);
        dog2.swim(10);
    }
}
