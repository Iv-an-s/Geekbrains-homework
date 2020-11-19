package part2.lesson8.impl;

import part2.lesson8.GBList;

public class DoubleLinkedList implements GBListForDoubleWay {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(null, val, null);
            last = first;
            size++;
            return;
        }
        Node current = new Node(last, val, null);
        last.next = current;
        last = current;
        size++;
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            size--;
            return true;
        }
        Node previous = first;
        Node current = previous.next;
        while (current.next != null) {
            if (current.val.equals(val)) {
                previous.next = current.next;
                current.next.prev = previous;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new RuntimeException("Индекс за пределами длины массива");
        }
        int count = 0;
        Node current = first;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.val;
    }

    @Override
    public String toString() {
        return "DoubleLinkedList{" +
                "first=" + first.val +
                ", last=" + last.val +
                ", size=" + size +
                '}';
    }
//
//    @Override
////    public GBIterator iterator() {
////        return new StraightForwardIterator(first);
////    }

    public DoubleWayIterator iterator() {
        return new DWIterator(first, last);
    }

    private static class Node {
        private Node prev;
        private String val;
        private Node next;

        public Node(Node prev, String val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    public static class DWIterator implements DoubleWayIterator {
        private Node currentForward;
        private Node currentBack;

        public DWIterator(Node first, Node last) {
            this.currentForward = first;
            this.currentBack = last;
        }

        @Override
        public boolean hasNext() {
            return currentForward != null;
        }

        public boolean hasPrevious(){
            return currentBack != null;
        }

        @Override
        public String next() {
            String val = currentForward.val;
            currentForward = currentForward.next;
            return val;
        }

        public String previous() {
            String val = currentBack.val;
            currentBack = currentBack.prev;
            return val;
        }
    }


//    public static class StraightForwardIterator implements GBIterator {
//        private Node current;
//
//        public StraightForwardIterator(Node current) {
//            this.current = current;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return current != null;
//        }
//
//        @Override
//        public String next() {
//            String val = current.val;
//            current = current.next;
//            return val;
//        }
//    }
}

