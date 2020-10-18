package part2.lesson1;

public class RunningTrack implements Obstruction {
    private int size;

    public RunningTrack(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
