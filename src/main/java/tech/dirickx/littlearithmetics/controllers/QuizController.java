package tech.dirickx.littlearithmetics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.services.modelservice.UserService;

import java.security.Principal;

@Controller
public class QuizController {

    UserService userService;


    QuizController(Quiz quiz){

    }

    @RequestMapping("/settings")
    public String settings(Principal principal, Model model){
        String userName =  principal.getName();

        model.addAttribute("userName", userName);
        return "/quiz/settings";
    }

    @RequestMapping("/overview")
    public String overview(){
        return "/report/overview";
    }


    @RequestMapping("/quiz")
    public String quiz(Model model){
        Quiz quiz = new Quiz();
        model.addAttribute("quiz",quiz);
        return "/quiz/quiz";
    }

    @RequestMapping("/quizAdmin")
    public String quizAdmin(Model model){
        Quiz quiz = (Quiz) model.getAttribute("quiz");
        return "/quiz/quiz";
    }
}
