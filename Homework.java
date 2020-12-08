package lesson6_homework;

import java.util.Arrays;

public class Homework {

    public static int[] returnModifiedArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i+1, array.length);
            }
        }
        throw new RuntimeException("The array has no the number 4");
    }

    public static boolean checkArray(int[] array) {
        boolean one = false;
        boolean four = false;
        for (int i : array) {
            if (i == 1) {
                one = true;
                break;
            }
        }
        for (int j : array) {
            if (j == 4) {
                four = true;
                break;
            }
        }
        return one & four;
    }
}
