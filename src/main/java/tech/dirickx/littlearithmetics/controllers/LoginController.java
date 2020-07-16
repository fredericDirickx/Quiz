package tech.dirickx.littlearithmetics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return ("login/login");
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Hello User</h1>";
    }


    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }


}
