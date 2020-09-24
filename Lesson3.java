import java.util.Random;
import java.util.Scanner;

// Написать программу, которая загадывает случайное число от 0 до 9,
// и пользователю дается 3 попытки угадать это число. При каждой попытке
// компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

public class Lesson3 {
    public static void main(String[] args) {
        int number = generateNumber();
        startGame(number);
    }

    public static int enterNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void startGame(int number) {
        System.out.println("Игра: УГАДАЙ ЧИСЛО");
        int attempt;
        while (true) {
            System.out.println("Введите число от 0 до 9");
            attempt = enterNumber();
            if (attempt > number) {
                System.out.println("Вы указали число, больше чем загаданное");
            } else if (attempt < number) {
                System.out.println("Вы указали число, меньше чем загаданное");
            } else {
                System.out.println("ПОЗДРАВЛЯЕМ! Вы угадали!!!");
                break;
            }
        }
        letsPlayOneMoreTime();
    }

    public static int generateNumber (){
        return new Random().nextInt(10);
    }
    public static void letsPlayOneMoreTime() {
        Scanner scanner = new Scanner(System.in);
        int interrupter = 0;
        boolean isItCorrect = false;
        while (!isItCorrect) {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            interrupter = scanner.nextInt();
            if (interrupter == 0 || interrupter == 1)
                isItCorrect = true;
        }
        if (interrupter ==1){
            int number = generateNumber();
            startGame(number);
        }
    }
}
