package part2.lesson7method;

public interface AuthService {
    void start ();
    String getNickByLoginPass (String login, String pass);
    void stop();
}

