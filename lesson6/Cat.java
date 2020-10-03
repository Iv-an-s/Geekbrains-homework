package lesson6;

//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
// прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).

public class Cat extends Animal {
    public Cat(String name, double runLimit, double jumpLimit, double swimLimit){
        super(name, runLimit, jumpLimit, swimLimit);
    }
}
