package in.kuru.main.controllers;

import in.kuru.main.entities.User;
import in.kuru.main.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/regPage")
    public String openRegPage(Model model){
        model.addAttribute("user", new User());
        return"register";
    }

    @PostMapping("/regForm")
    public String submitRegForm(@ModelAttribute("user") User user, Model model){
        boolean status=userService.addUser(user);

        if(status){
            model.addAttribute("successMsg", "user registered successfully");
            return"login";
        }else{
            model.addAttribute("errorMsg", "couldn't register due to some error");
            return "register";
        }
    }

    @GetMapping("/loginPage")
    public String openLoginPage(Model model){
        model.addAttribute("user", new User());
        return"login";
    }


    @PostMapping("/loginForm")
    public String submitLoginForm(@ModelAttribute("user") User user, Model model){
        User validUser= userService.loginUser(user.getEmail(), user.getPassword());
        System.out.println(validUser);
        if(validUser!=null){
            return "profile";
        }else{
            model.addAttribute("errorMsg", "email and password didnt match");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(false);

        if(session!=null){
            session.invalidate();
            return "redirect:/loginPage";
        }else{
            return "redirect:/loginPage";
        }
    }




}
