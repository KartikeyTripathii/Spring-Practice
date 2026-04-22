package in.kuru.main.mycontroller;

import in.kuru.main.entities.User;
import in.kuru.main.service.MyService;
import in.kuru.main.service.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController
{
    @Autowired
    private MyService myService;
    @GetMapping("/regpage")
    public String openRegistrationMap(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/regForm")
    public String submitRegForm(@ModelAttribute("user") User user, Model model){
        boolean status=myService.registerUser(user);
        if(status){
            model.addAttribute("successMsg", "user Registered successfully");
        }else{
            model.addAttribute("errorMsg", "user not Registered due to some error");

        }
        return "register";
    }
}
