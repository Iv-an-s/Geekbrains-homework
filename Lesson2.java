import java.util.Random;

public class Lesson2 {
    public static void main(String[] args) {

// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int [] mass = new int [10];
        for (int i = 0; i < mass.length; i++ ){
            mass[i] = new Random().nextInt(2);
//            System.out.print(mass[i] + ", ");
        }
//        System.out.println("");
        for (int i =0; i < mass.length; i++){
            if (mass [i] ==0) mass[i] = 1;
            else if (mass [i] ==1) mass[i] = 0;
//            System.out.print(mass[i] + ", ");
        }

// 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int [] mass2 = new int[8];
        for (int i = 0; i < mass2.length; i++){
            mass2[i] = i * 3;
        }
// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
// пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int [] mass3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mass3.length; i++){
            if (mass3[i] < 6)
                mass3[i] = mass3[i] * 2;
        }
// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int [][] doubleMass = new int [10][10];
        for (int i = 0; i < doubleMass.length; i++){
            doubleMass[i][i] = 1;
        }
// 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int [] mass5 = new int [10];
        for (int i = 0; i < mass5.length; i ++){
            mass5[i] = new Random().nextInt(100);
            System.out.println(mass5[i]);
        }
        int min = mass5[0];
        int max = mass5[0];
        for (int i = 1; i< mass5.length; i++){
            if (mass5[i] < min){
                min = mass5[i];
            }
            if (mass5[i] > max){
                max = mass5[i];
            }
        }
        System.out.println("Максимальный элемент - это " + max);
        System.out.println("Минимальный элемент - это " + min);
    }
// 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance (int [] mass){
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < mass.length/2; i++){
            sumLeft = sumLeft + mass[i];
            for (int j = mass.length-1; j > mass.length/2; j --){
                sumRight = sumRight + mass [j];
                if (sumLeft == sumRight) return true;
            }
        }
        return false;
    }
// 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
// или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    public static int[] task7 (int [] mass, int n){
        if (n >= 0){
            for (int i = mass.length-1; i > 0; i--){
                if ((i-n)>=0) {
                    mass[i] = mass[i - n];
                }else mass[i] = 0;
            }
        }
        if (n < 0){
            for (int i = 0; i < mass.length-1; i++){
                if ((i + n)>=0){
                    mass[i+n] = mass[i];
                    mass[i] = 0;
                }
            }
        }
        return mass;
    }
}
