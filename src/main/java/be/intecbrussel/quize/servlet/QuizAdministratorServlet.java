package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.temporal.Temporal;

@WebServlet("/quizAdmin")
public class QuizAdministratorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<p>doGet quizService</p>");

        int index = 0;

        if (session.isNew()) {
            QuizService quizService = (QuizService) req.getAttribute("quizService");
            session.setAttribute("sessionQuizService", quizService);
            session.setAttribute("index", 0);
        }

        QuizService quizService =(QuizService) session.getAttribute("quizService");
        for(Question q : quizService.getQuestions()) {

            writer.println("<p>");
            writer.println(q.getQuestionString());
            writer.println("</p>");

        }



    }


    public long getDuration(Temporal start, Temporal end) {
        Duration duration = Duration.between(start, end);
        return duration.toSeconds();
    }


}
