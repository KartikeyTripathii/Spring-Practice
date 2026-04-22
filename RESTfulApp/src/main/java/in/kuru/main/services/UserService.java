package in.kuru.main.services;

import in.kuru.main.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);
    User updateUserDetail(int id, User user);
}
