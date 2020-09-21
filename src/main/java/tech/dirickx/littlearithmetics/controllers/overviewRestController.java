package tech.dirickx.littlearithmetics.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.services.reposervices.QuizService;
import tech.dirickx.littlearithmetics.services.reposervices.UserService;

import java.security.Principal;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class overviewRestController {

    QuizService quizService;
    UserService userService;

    @Autowired
    public void setQuizService(QuizService quizService) {
        this.quizService = quizService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/overview/all")
    public List<Question> all(Principal principal){
        List<Question> questionList = new ArrayList<>();
        List<Quiz> quizList = quizService.findListOfQuizByUserName(principal.getName());
        for (Quiz quiz : quizList) {
            for (Question question : quiz.getQuestions()) {
                questionList.add(question);
            }
        }
        return questionList;
    }

    @JsonIgnore
    @RequestMapping("/allQuiz")
    public List<Quiz> allQuiz(Principal principal){
        List<Quiz> quizList = quizService.findListOfQuizByUserName(principal.getName());
        System.out.println(quizList.toString());
        return quizService.findListOfQuizByUserName(principal.getName());
    }

    @RequestMapping("/greetings")
    public String all(){
        return "{\"id\":1,\"content\":\"Hello, World!\"}";
    }


}
