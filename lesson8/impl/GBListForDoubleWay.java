package part2.lesson8.impl;

public interface GBListForDoubleWay extends DoubleWayIterable {
    void add (String val);
    boolean remove (String val);
    int size ();
    String get (int index);
}
