public class Lesson1 {
    public static void main(String[] args) {
        byte byteVar = 1;
        short shortVar = 2;
        int intVar = 3;
        long longVar = 4L;
        float floatVar = 1.0f;
        double doubleVar = 1.0;
        char charVar = 'c';
        boolean isTrue = true;
        String str = "some string";
    }

//    Написать метод вычисляющий выражение a * (b + (c / d))
    public static int task3(int a, int b, int c, int d) {
        if (d != 0) {
            int result = a * (b + (c / d));
            return result;
        } else {
            return -1111111111;
        }
    }
//    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
//    в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean task4 (int a, int b){
        int sum = a + b;
        if (sum >10 && sum <=20){
            return true;
        }else{
            return  false;
        }
    }
//    5. Написать метод, которому в качестве параметра передается целое число, метод должен
//    напечатать в консоль положительное ли число передали, или отрицательное;
//    Замечание: ноль считаем положительным числом.
    public static void task5 (int a){
        if (a < 0){
            System.out.println("Число a =" + a + " - отрицательное.");
        } else
            System.out.println("Число a =" + a + " - положительное.");
    }
//    6. Написать метод, которому в качестве параметра передается целое число, метод должен
//    вернуть true, если число отрицательное;
    public static boolean task6 (int a){
        if (a < 0) return true;
        return false;
    }

//    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
//    метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void task7(String name){
        System.out.println("Привет, " + name);
    }

//    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void task8 (int year){
        if (year % 4 ==0 && year % 100 != 0){
            System.out.println("Год " + year + " - високосный");
        }else if (year % 400 == 0){
            System.out.println("Год " + year + " - високосный");
        }else{
            System.out.println("Год " + year + " - НЕ високосный");
        }
    }
}
