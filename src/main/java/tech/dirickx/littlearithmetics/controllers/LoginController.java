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
import tech.dirickx.littlearithmetics.services.reposervices.RoleService;
import tech.dirickx.littlearithmetics.services.reposervices.UserService;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class LoginController {

    private UserService userService;
    private RoleService roleService;
    private final  String defaultRole = "ROLE_USER";



    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
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
        Role role = createRoleIfNotExists(defaultRole);
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        userService.save(user);
        return "login/login";
    }

    public Role createRoleIfNotExists(String name) {
        Role role = roleService.findRoleByName(name);
       if( role == null){
           Role newRole = new Role();
           newRole.setName(name);
           roleService.save(newRole);
       }
       return role;
    }


    @RequestMapping("/logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "login/logout";
    }


}
