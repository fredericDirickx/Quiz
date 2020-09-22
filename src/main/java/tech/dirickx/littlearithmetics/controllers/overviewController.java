package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.services.modelservice.impl.QuizReportService;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/overview")
@Controller
public class overviewController {

    private QuizService quizService;
    private QuizReportService quizReportService;

    @Autowired
    public void setQuizReportService(QuizReportService quizReportService){
        this.quizReportService = quizReportService;
    }

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/list")
    public String simpleOverview(Principal principal, Model model){
        List<Quiz> quizList = quizService.findListOfQuizByUserName(principal.getName());
        model.addAttribute("quizList", quizList);
        return "overview/list";
    }

    @RequestMapping("/byQuizGraph/{id}")
    public String overviewOfQuiz(@PathVariable Long id, Model model){
        quizReportService.setQuiz(quizService.findQuizById(id));
        model.addAttribute("quizReport", quizReportService);
        return "overview/byQuizGraph";
    }

    @RequestMapping("/report/{id}")
    public String reportOfQuiz(@PathVariable Long id, Model model){
        quizReportService.setQuiz(quizService.findQuizById(id));
        model.addAttribute("report", quizReportService);
        return "overview/report";
    }


    @RequestMapping("/all")
    public String all(){
        return "/overview/all";
    }






}
