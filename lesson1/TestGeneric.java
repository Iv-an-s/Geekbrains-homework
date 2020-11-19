package part3.lesson1;

import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {

        GenericArray<String> example = new GenericArray<>();
        String[] array = {"one", "two", "three", "four", "five"};
        array = example.replaceElements(array, 1, 3);
        for (String s : array) {
            System.out.print(s + ", ");
        }
        System.out.println("");

        ArrayList<String> list = example.convertArrayToArrayList(array);
        list.add("six");
        for (String s : list){
            System.out.print(s + ", ");
        }
    }
}
