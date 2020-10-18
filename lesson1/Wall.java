package part2.lesson1;

public class Wall implements Obstruction{
    private int size;

    public Wall(int high) {
        this.size = high;
    }

    public int getSize(){
        return size;
    }
}
