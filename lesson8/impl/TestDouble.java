package part2.lesson8.impl;

public class TestDouble {
    public static void main(String[] args) {
        GBListForDoubleWay list = new DoubleLinkedList();

        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        System.out.println(String.format("List size is: %s", list.size()));

        list.remove("222");

        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("size of list is: " + list.size());
        System.out.println(list.toString());

        DoubleWayIterator iterator = list.iterator();
        while(true){
            if (iterator.hasNext()){
                System.out.println(iterator.next());
            }else{
                break;
            }
        }

        System.out.println("А теперь обратно ...");

        while (true){
            if (iterator.hasPrevious()){
                System.out.println(iterator.previous());
            }else{
                break;
            }
        }
    }
}
