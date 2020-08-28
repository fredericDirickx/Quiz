package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.services.UserService;

import java.time.LocalDate;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return ("login/login");
    }

    @GetMapping("/newUser")
    public String user(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("startDate", LocalDate.now());
        return "login/newUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveNewUser(User user) {
        Role role = new Role();
        role.setName("USER");
        user.addRole(role);
        Person person = user.getPerson();
        person.setUser(user);
        userService.save(user);
        return "login/login";
    }


    @GetMapping("/settings")
    public String settings() {
        return ("quiz/settings");
    }

}
