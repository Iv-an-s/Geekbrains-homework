package part2.lesson8;

import part2.lesson8.impl.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("GAZ");
        list.add("TAZ");
        list.add("VAZ");

        GBIterator iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
//            System.out.println(next);
        }

//        list.remove("GAZ");
//        System.out.println(list);

        System.out.println(list.size());

        System.out.println(list.get(3));

    }
}
