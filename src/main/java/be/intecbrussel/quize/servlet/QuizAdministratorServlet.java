package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.model.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

@WebServlet("/quizAdmin")
public class QuizAdministratorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Temporal now = LocalDateTime.now();
        HttpSession session = req.getSession();
        session.setAttribute("startTime", now);
        int index = convertToInteger(session.getAttribute("index"));
        QuizService quizService = (QuizService) session.getAttribute("quizService");
        int amountOfQuestions = quizService.getAmountQuestions();
        int progress = progressPercentage(amountOfQuestions,index);
        String buttonText = buttonText(amountOfQuestions,index);

        quizService.getStartTimes().add(now);
        String question = quizService.getQuestions().get(index).getQuestionString();
        req.setAttribute("question", question);
        req.setAttribute("index", ++index);
        req.setAttribute("progress", progress);
        req.setAttribute("buttonText", buttonText);

        req.getRequestDispatcher("/WEB-INF/pages/quiz.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Temporal endTime = LocalDateTime.now();
        Temporal startTime = (Temporal) session.getAttribute("startTime");
        long duration = getDuration(startTime, endTime);

        int index = convertToInteger(session.getAttribute("index"));
        double answer = Double.parseDouble(req.getParameter("answer"));


        QuizService quizService = (QuizService) session.getAttribute("quizService");
        quizService.getQuestions().get(index).setAnswer(answer);
        quizService.getQuestions().get(index).setDuration(duration);
        quizService.getEndTimes().add(endTime);

        session.setAttribute("index", req.getParameter("index"));

        req.getRequestDispatcher("/quizAdmin");



        if (index < quizService.getQuestions().size()-1) {
            resp.sendRedirect("/quiz/quizAdmin");
        } else {
            resp.sendRedirect("/quiz/report");
        }
    }


    public long getDuration(Temporal start, Temporal end) {
        Duration duration = Duration.between(start, end);
        return duration.toSeconds();
    }

    public int convertToInteger(Object object) {
        int result = 0;
        try {
            result = Integer.parseInt((String) object);
            return result;
        } catch (ClassCastException exString) {
            try {
                result = (Integer) object;
                return result;
            } catch (ClassCastException exInt) {
                return result;
            }
        }
    }

    public int progressPercentage(int total, int done){
        return (int) (100/total)*done;
    }

    public String buttonText(int total, int index){
        return index<total-1? "next":"finished!";
    }


}
