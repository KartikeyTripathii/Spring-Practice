package in.kuru.main.services;

import in.kuru.main.entities.User;
import in.kuru.main.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepo repo;

    @Override
    public User createUser(User user)
    {
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers()
    {
        return repo.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id)
    {
        return repo.findById(id);
    }

    @Override
    public User updateUserDetail(int id, User user)
    {
        User old= repo.findById(id).orElse(null);
        if(old!=null){
            return repo.save(user);
        }else{
            throw new RuntimeException("no user found of id: "+id);
        }

    }
}
