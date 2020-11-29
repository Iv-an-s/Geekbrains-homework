package part3.lesson3.DB;

import part3.lesson3.DB.DataSource;
import part3.lesson3.DB.UserRepository;

public class Main {
    public static void main(String[] args) {
//        DriverManager.drivers().forEach(System.out::println);
        DataSource.getConnection();
        UserRepository userRepository = new UserRepository();

//        User user1 = new User(2, "User-2", "u2@mail.ru", "u2");
//        userRepository.save(user1);

        System.out.println(userRepository.getNickByLoginPass("u1@mail.ru", "u1"));

        userRepository.changeNick("u1", "vasya");
    }
}
