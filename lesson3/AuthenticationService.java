package part3.lesson3;

import part3.lesson3.DB.User;
import part3.lesson3.DB.UserRepository;

public class AuthenticationService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User doAuth(String email, String password){
        return  userRepository.findUserByEmailAndPassword(email, password);

    }
}
