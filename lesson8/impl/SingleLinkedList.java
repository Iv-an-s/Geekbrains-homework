package part2.lesson8.impl;

import part2.lesson8.GBIterator;
import part2.lesson8.GBList;

public class SingleLinkedList implements GBList {
    private Node first;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null){
            first = new Node(val);
            size++;
            return;
        }else{
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val){
        if (current.next ==null){
            current.next = new Node(val);
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)){
            first = first.next;
            size --;
            return true;
        }
        Node prev = first;
        Node current = first.next;
        while (current != null ){
            if (current.val.equals(val)){
     //           prev = new Node(prev.val, current.next);
                prev.setNext(current.next);
                size--;
                return true;
            }
            prev = current;
            current = current.next;

        }
        return false;
    }

    @Override
    public int size() {
//        int i = 0;
//        GBIterator iterator = new StraightForwardIterator(first);
//        while (iterator.hasNext())
//            i++;
//            iterator.next();
//        return i;
        return size;
    }

    @Override
    public GBIterator iterator() {
        return new StraightForwardIterator(first);
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                '}';
    }

    @Override
    public String get(int index) {
        if (index >= size){
            throw new RuntimeException("Индекс за пределами длины массива");
        }
        int count = 0;
        Node current = first;
        while (count!=index){
            current = current.next;
            count++;
        }
        return current.val;
    }

    private static class Node {
        private String val;
        private Node next;

        public Node(String val) {
            this.val = val;
            this.next = null;
        }

        public Node(String val, Node next) {
            this.next = next;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static class StraightForwardIterator implements GBIterator {
        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public  boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }
    }
}
