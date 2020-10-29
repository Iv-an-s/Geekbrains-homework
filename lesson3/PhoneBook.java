package part2.lesson3;

/*2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    В этот телефонный справочник с помощью метода add() можно добавлять записи.
    С помощью метода get() искать номер телефона по фамилии.
    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    тогда при запросе такой фамилии должны выводиться все телефоны.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<String, String> phoneBook;

    public PhoneBook(Map<String, String> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String phoneNumber, String surname){
        phoneBook.put(phoneNumber, surname);
    }

    public String get(String surname){
        List<String>list = new ArrayList<>();
        for (Map.Entry pair : phoneBook.entrySet()){
            if (pair.getValue().equals(surname)){
                list.add((String) pair.getKey());
            }
        }
        return String.format("По фамилии '%s' найдены следующие номера телефонов: %s", surname, list);
    }
}
