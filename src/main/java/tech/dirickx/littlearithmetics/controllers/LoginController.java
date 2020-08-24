package tech.dirickx.littlearithmetics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return ("login/login");
    }

    @GetMapping("/newUser")
    public String user() {
        return "login/newUser";
    }


    @GetMapping("/settings")
    public String admin() {
        return ("quiz/settings");
    }

}
