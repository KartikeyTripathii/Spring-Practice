package in.kuru.main.controllers;

import in.kuru.main.entities.User;
import in.kuru.main.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserServiceImpl service;


    @GetMapping("/index")
    public String openHomePage(){
        return "index";
    }

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user)
    {
        return service.createUser(user);
    }

    @GetMapping("/getusers")
    public List<User> displayAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> displayUserById(@PathVariable Integer id)
    {
        User user=service.getUserById(id).orElse(null);
        if(user!=null){
            return ResponseEntity.ok().body(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/getuser/{id}")
    public ResponseEntity<User> updateUserData(@PathVariable int id,@RequestBody User user){
        User updatedUser=service.updateUserDetail(id,user);
        if(updatedUser!=null){
            return ResponseEntity.ok().body(updatedUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
