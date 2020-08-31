package tech.dirickx.littlearithmetics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.dirickx.littlearithmetics.models.User;

@Controller
public class QuizController {

    @RequestMapping("/settings")
    public String settings(Model model){
        User user = (User) model.getAttribute("user");
        return "/quiz/settings";
    }

    @RequestMapping("/overview")
    public String overview(){
        return "/report/overview";
    }
}
