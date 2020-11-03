package part2.lesson4;

import java.util.*;

public class SortedTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Pavel", 32);
        map.put("Anna", 28);
        map.put("Petr", 45);
        map.put("Vera", 37);
        map.put("Maks", 31);

        sortByValue(map);
    }

    public static void sortByValue(TreeMap<String, Integer> map){
        ArrayList<Integer> mapValues = new ArrayList<>(new TreeSet<>(map.values()));
        for (int i = 0; i < mapValues.size(); i++) {
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (mapValues.get(i).equals(pair.getValue())){
                    System.out.println(pair.getKey() + "=" + pair.getValue());
                }
            }
        }
    }
}
