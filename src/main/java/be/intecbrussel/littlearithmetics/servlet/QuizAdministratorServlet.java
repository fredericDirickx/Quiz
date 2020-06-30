package be.intecbrussel.littlearithmetics.servlet;

import be.intecbrussel.littlearithmetics.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

@WebServlet("/quizAdmin")
public class QuizAdministratorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime now = LocalDateTime.now();
        HttpSession session = req.getSession();
        session.setAttribute("startTime", now);
        int index = convertToInteger(session.getAttribute("index"));
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        int amountOfQuestions = quiz.getAmountQuestions();
        int progress = progressPercentage(amountOfQuestions,index);
        String buttonText = buttonText(amountOfQuestions,index);

        quiz.getQuestions().get(index).getAnswer().setStartTime(now);
        String question = quiz.getQuestions().get(index).toString();
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

        int index = convertToInteger(session.getAttribute("index"));
        BigDecimal answer = new BigDecimal(req.getParameter("answer"));

        Quiz quiz = (Quiz) session.getAttribute("quiz");
        quiz.getQuestions().get(index).getAnswer().setAnswer(answer);
        quiz.getQuestions().get(index).getAnswer().setEndTime(LocalDateTime.now());

        session.setAttribute("index", req.getParameter("index"));

//        req.getRequestDispatcher("/quizAdmin");

        if (index < quiz.getQuestions().size()-1) {
            resp.sendRedirect("/quiz/quizAdmin");
        } else {
            resp.sendRedirect("/quiz/report");
        }
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
