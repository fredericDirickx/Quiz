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
import java.util.List;

@WebServlet("/report")
public class QuizReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
        QuizService quizService = (QuizService) session.getAttribute("quizService");
        List<Question> questionList =  quizService.getQuestions();
        req.setAttribute("reportList",questionList);
        req.getRequestDispatcher("/WEB-INF/pages/quizReport.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
