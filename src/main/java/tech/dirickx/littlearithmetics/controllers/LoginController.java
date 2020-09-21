package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.dirickx.littlearithmetics.models.*;
import tech.dirickx.littlearithmetics.repositories.AddressRepository;
import tech.dirickx.littlearithmetics.services.reposervices.PersonService;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;
import tech.dirickx.littlearithmetics.services.reposervices.UserService;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class LoginController {

    private UserService userService;
    private PersonService personService;



    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/login")
    public String login() {
        return ("login/login");
    }

    @GetMapping("/newUser")
    public String user(Model model, Principal principal) {
            model.addAttribute("user", new User());
            model.addAttribute("startDate", LocalDate.now());
        return "login/newUser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setId(2);
        user.addRole(role);
        user.getPerson().setUser(user);
        user.getPerson().getAddress().setPerson(user.getPerson());
        userService.save(user);
        return "login/login";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(User user) {
        Person person = user.getPerson();
        person.setUser(new User());
        person.getUser().setId(user.getId());
        person.setAddress(user.getPerson().getAddress());
        person.getAddress().setPerson(person);
        personService.save(person);
        return "login/login";
    }



    @GetMapping("/manageAccount")
    public String manageAccount(Model model, Principal principal){
        User user = userService.findUserByName(principal.getName());
        model.addAttribute("user", user);
        return "login/manageAccount";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "login/logout";
    }


}
