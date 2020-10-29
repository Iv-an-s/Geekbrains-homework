package part2.lesson3;

import java.util.HashMap;
import java.util.Map;

public class TestPhoneBook {
    public static void main(String[] args) {
        Map <String, String> map = new HashMap<>();
        map.put("12345678", "Ivanov");
        map.put("09877654", "Petrov");
        map.put("11111111", "Sidorov");
        map.put("22222222", "Ivanov");

        PhoneBook phoneBook = new PhoneBook(map);
        phoneBook.add("3333333", "Ivanov");
        System.out.println(phoneBook.get("Ivanov"));
    }
}
