package part3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericArray<T> {
    public T[] replaceElements(T[] array, int index1, int index2){
        if(index1 >=array.length || index2 >=array.length){
            throw new RuntimeException("Индекс за пределом массива");
        }
        T temp = array [index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }
    public ArrayList<T> convertArrayToArrayList (T[]array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
