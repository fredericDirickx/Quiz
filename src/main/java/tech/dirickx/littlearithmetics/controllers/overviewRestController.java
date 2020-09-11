package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;

import java.security.Principal;
import java.util.List;

@RestController
public class overviewRestController {

    QuizService quizService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/overview/all")
    public List<Quiz> all(Principal principal){
        return quizService.findListOfQuizByUserName("Frits");
    }


}
