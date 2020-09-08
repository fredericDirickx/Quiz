package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;

@RequestMapping("/overview")
@Controller
public class overviewController {

    private QuizService quizService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/simple")
    public String simpleOverview(){
        return "/report/overview";
    }






}
