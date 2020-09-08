package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.dirickx.littlearithmetics.models.Answer;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.services.modelservice.QuizModelService;
import tech.dirickx.littlearithmetics.services.modelservice.impl.QuizModelServiceImpl;
import tech.dirickx.littlearithmetics.services.modelservice.impl.QuizReportService;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;
import tech.dirickx.littlearithmetics.services.reposervices.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;

@RequestMapping("/quiz")
@Controller
public class QuizController {

    QuizService quizService;
    UserService userService;
    Quiz quiz;


    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "/index";
    }

    @RequestMapping("/settings")
    public String settings(Principal principal, Model model) {
        User user = getUserFromPrincipal(principal);
        this.quiz = new Quiz();
        quiz.setUser(user);
        model.addAttribute("quiz", quiz);
        return "/quiz/settings";
    }

    public User getUserFromPrincipal(Principal principal) {
        String userName = principal.getName();
        return this.userService.findUserByName(userName);
    }




    @RequestMapping(value = "/question", method = RequestMethod.POST)
    public String questionStart(Quiz quiz, Model model) {
        this.quiz.setSettings(quiz.getSettings());
        this.quiz.setBoundaries(quiz.getBoundaries());
        this.quiz.setAmountQuestions(quiz.getAmountQuestions());

        QuizModelService quizModelService = new QuizModelServiceImpl();
        quizModelService.createQuestions(this.quiz);
        int questionNr = 0;

        setStartDateToCurrentAnswer(questionNr,LocalDateTime.now());

        modelAddAttributes(model,questionNr);

        return "/quiz/quiz";
    }

    @RequestMapping(value = "/question/{questionNr}", method = RequestMethod.POST)
    public String question(Answer answer, Model model, @PathVariable Integer questionNr) {

        LocalDateTime now = LocalDateTime.now();
        setEndDateToPreviousAnswer(questionNr, now);

        this.quiz.getQuestions().get(questionNr).getAnswer().setAnswer(answer.getAnswer());

        if (isEndOfQuiz(questionNr)) {
            quizService.save(this.quiz);
            QuizReportService reportService = new QuizReportService();
            reportService.setQuiz(this.quiz);
            model.addAttribute("report", reportService);
            return "/report/report";
        }

        ++questionNr;
        setStartDateToCurrentAnswer(questionNr,now);

        modelAddAttributes(model,questionNr);


        return "/quiz/quiz";
    }

    public void modelAddAttributes(Model model, int questionNr){
        model.addAttribute("quiz", this.quiz);
        model.addAttribute("answer", new Answer());
        model.addAttribute("questionNr", questionNr);
        model.addAttribute("progress", progressBarController(questionNr));
        model.addAttribute("buttonText", buttonTextController(questionNr));
    }


    public double progressBarController(int questionNr) {
        return (double) (questionNr * 100) / this.quiz.getAmountQuestions();
    }

    public void setEndDateToPreviousAnswer(int currentQuestionNr, LocalDateTime endDate) {
        this.quiz
                .getQuestions()
                .get(currentQuestionNr)
                .getAnswer()
                .setEndTime(endDate);
    }

    public void setStartDateToCurrentAnswer(int currentQuestionNr, LocalDateTime startDate) {
        this.quiz
                .getQuestions()
                .get(currentQuestionNr)
                .getAnswer()
                .setStartTime(startDate);
    }



    public String buttonTextController(int questionNr) {
        if (questionNr >= this.quiz.getAmountQuestions()) {
            return "lastQuestion";
        }
        return "next";
    }

    public boolean isEndOfQuiz(int questionNr) {
        return questionNr >= this.quiz.getAmountQuestions()-1;
    }


    @RequestMapping("/overview")
    public String overview() {
        return "/report/overview";
    }


}



