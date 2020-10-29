package part2.lesson3;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String [] arrayOfWords = new String[] {"one", "two", "three", "four", "five", "six",
                                        "seven", "eight", "nine", "o", "one", "two", "three", "one"};
        List<String> listOfWords = new ArrayList<>(Arrays.asList(arrayOfWords));

        System.out.println(getListOfUniqueWordsFromArray(arrayOfWords));
        System.out.println(getListOfUniqueWordsFromList(listOfWords));
        System.out.println(getNumberOfRepeats(arrayOfWords, 1));
        System.out.println(getNumberOfRepeats(arrayOfWords, "two"));
        System.out.println(countOfEveryWord(arrayOfWords));
        System.out.println(countOfEveryWord(listOfWords));
    }

    public static List <String> getListOfUniqueWordsFromArray (String [] array){
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!newList.contains(array[i])) newList.add(array[i]);
        }
        return newList;
    }

    public static List <String> getListOfUniqueWordsFromList (List <String> list){
        for (int i = 1; i < list.size(); i++) {
            if (list.subList(0, i-1).contains(list.get(i))){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public static int getNumberOfRepeats (String [] array, String word){
        int num = 0;
        for (String wordd : array){
            if (word.equals(wordd)){
                num++;
            }
        }
        return num;
    }

    public static int getNumberOfRepeats (String [] array, int indexOfWord){
        int num = 0;
        for (String word : array){
            if (word.equals(array[indexOfWord])){
                num++;
            }
        }
        return num;
    }

    public static Map <String, Integer> countOfEveryWord (String [] words){
        Map <String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++){
                if (map.containsKey(words[i])){
                    map.put(words[i], map.get(words[i])+1);
                }else{
                    map.put(words[i], 1);
                }
            }
        return map;
    }

    public static Map <String, Integer> countOfEveryWord (List <String> words){
        Map <String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.size(); i++){
            if (map.containsKey(words.get(i))){
                map.put(words.get(i), map.get(words.get(i))+1);
            }else{
                map.put(words.get(i), 1);
            }
        }
        return map;
    }
}
