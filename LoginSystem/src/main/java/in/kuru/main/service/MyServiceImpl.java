package in.kuru.main.service;

import in.kuru.main.entities.User;
import in.kuru.main.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService
{
    @Autowired
    private MyRepository myRepository;

    @Override
    public boolean registerUser(User user) {
        try{
        myRepository.save(user);
        return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
