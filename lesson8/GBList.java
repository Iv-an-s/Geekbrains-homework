package part2.lesson8;

public interface GBList extends GBIterable{
    void add (String val);
    boolean remove (String val);
    int size ();
    String get (int index);
}
