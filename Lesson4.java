import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Please input the size of the game field");
        int size = scanner.nextInt();
        play(scanner, random, size);
    }

    public static void play(Scanner scanner, Random random, int size){
        char[][] field = getField(size);
        do {
            doPlayerMove(scanner, field, size);
            if(isFinal(field, 'X')){
                break;
            }
            doCompMove(random, field, size);
            if(isFinal(field, '0')){
                break;
            }
            drawField(field);
        }while (true);
        System.out.println("Final score:");
        drawField(field);
    }

    static boolean isFinal(char[][]field, char sign){
        if (!isDraw(field)){
            System.out.println("Thanks God no one win");
            return true;
        }
        if (isWin(field, sign)){
            String name = sign=='X'? "Player": "Comp";
            System.out.println(String.format("%s won!", name));
            return true;
        }
        return false;
    }

    public static boolean isWin(char[][]field, char sign){
        boolean resultHor = false;
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j]==sign){
                    resultHor=true;
                }else {
                    resultHor = false;
                    break;
                }
            }
            if (resultHor) return resultHor;
        }

        boolean resultVert = false;
        for (int i = 0; i < field[0].length; i++){
            for (int j = 0; j < field.length; j++){
                if(field[j][i] == sign){
                    resultVert = true;
                }else{
                    resultVert = false;
                    break;
                }
            }
            if (resultVert) return resultVert;
        }

        boolean resultDiagonal = false;
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == sign) {
                resultDiagonal = true;
            } else {
                resultDiagonal = false;
                break;
            }
        }
        if (resultDiagonal) return resultDiagonal;

        for(int i = 0; i < field.length; i++){
            if (field[i][field.length-i-1] == sign){
                resultDiagonal = true;
            }else {
                resultDiagonal = false;
                break;
            }
        }
        if(resultDiagonal) return resultDiagonal;
        return false;
    }

    public static boolean isDraw(char[][]field){
        for (int i = 0; i< field.length; i ++){
            for (int j = 0; j < field[i].length; j ++){
                if (field[i][j]=='-'){
                    return true;
                }
            }
        }
        return false;
    }

    public static void doCompMove(Random random, char[][] field, int size){
        int x, y;
        do {
            x = random.nextInt(size);
    //Оптимизировать на предмет того, что если х правильный, далее искать только 'у'
            y = random.nextInt(size);
        }while (field[x][y]!='-');
        field[x][y] = '0';
    }

    public static void doPlayerMove (Scanner scanner, char[][] field, int size){
        int x, y;
        do{
            x = getCoordinate(scanner, size, 'X');
            y = getCoordinate(scanner, size, 'Y');
        }while (field[x][y] != '-');
        field[x][y] = 'X';
    }


    public static int getCoordinate(Scanner scanner, int size, char coordName){
        int coordinate;
        do {
            System.out.println(String.format("Please input %s - coordinate in range [1 .. %s]", coordName, size));
            coordinate = scanner.nextInt() - 1;
        }while (coordinate < 0 || coordinate >= size);
        return coordinate;
    }

    public static char[][] getField(int size){
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                field [i][j] = '-';
            }
        }
        return field;
    }
    public static void drawField(char[][] field){
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }
}
