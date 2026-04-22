package in.kuru.main.services;

import in.kuru.main.entities.User;

public interface UserService {
    boolean addUser(User user);
    User loginUser(String email, String password);
}
