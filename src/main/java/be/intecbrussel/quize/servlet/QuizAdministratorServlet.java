package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.dao.QuizServiceDao;
import be.intecbrussel.quize.model.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/quizAdmin")
public class QuizAdministratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] answers = parameterMap.get("answer");
        String[] questions = parameterMap.get("question");
        String userName = req.getParameter("userName");

        QuizService quizService = QuizService.createQuiz(answers, questions, userName);
        QuizServiceDao quizServiceDao = new QuizServiceDao();
        quizServiceDao.create(quizService);

        List<String> reportList = quizService.gradeQuizToList();

        session.setAttribute("reportList",reportList);

        req.getRequestDispatcher("/quizReport.jsp").forward(req,resp);

    }
}
