package part3.lesson1.task3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList <T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public double getWeight(){
        if(box.size()>0) {
            return box.size() * box.get(0).getWeightOfOne();
        }else{
            throw new RuntimeException("The box is empty");
        }
        // исходил из того, что в одну ячейку добавляется один фрукт.
    }

    public boolean compare (Box box){
        if (getWeight()==box.getWeight()){
            return true;
        }
        return false;
    }

    public Box<T> transship (Box <T> box){     // аргумент - это то, куда пересыпаем
        box.box.addAll(this.box);
        this.box.clear();
        return box;
    }

    public void add (T fruit){
        this.box.add(fruit);
    }

    public ArrayList<T> getBox() {
        return box;
    }
}
