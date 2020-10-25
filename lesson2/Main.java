package lesson2;
/*  1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
        при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст
        вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке
        лежат неверные данные.
    3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
        MyArrayDataException, и вывести результат расчета.
*/
public class Main {
    public static void main(String[] args) {
        String [][] mass = new String[4][4];
        for (int i = 0; i <mass.length ; i++) {
            for (int j = 0; j <mass[i].length ; j++) {
                mass[i][j] = "" + i*j;
            }
        }
//        mass[2][3] = mass[2][3]+"abc";
        int sum = 0;
        try{
            sum = sumArrayElements(mass);
        }catch (MyArraySizeException ex){
            ex.printStackTrace();
            System.out.println("Расчет суммы не произведен");
        }catch (MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Расчет суммы не произведен");
        }finally {
            System.out.println("Result is: " + sum);
        }
    }

    public static int sumArrayElements (String [][] mass) throws MyArraySizeException, MyArrayDataException{
        if (mass.length != 4 || mass[0].length!=4){
            throw new MyArraySizeException("Array size is not correct");
        }
        int sum = 0;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j <mass[i].length ; j++) {
                try{
                    sum += Integer.parseInt(mass[i][j]);
                }catch (Exception ex){
                    throw new MyArrayDataException(String.format("Wrong value of element [%s][%s]", i, j));
                }
            }
        }
        return sum;
    }
}
