package be.intecbrussel.littlearithmetics.servlet;

import be.intecbrussel.littlearithmetics.dao.Dao;
import be.intecbrussel.littlearithmetics.dao.impl.QuizDaoImpl;
import be.intecbrussel.littlearithmetics.service.impl.QuizReportService;
import be.intecbrussel.littlearithmetics.view.StringFormat;
import be.intecbrussel.littlearithmetics.model.Quiz;

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

        Quiz quiz = (Quiz) session.getAttribute("quiz");

        Dao dao = new QuizDaoImpl();
        dao.create(quiz);
        QuizReportService quizReport = new QuizReportService();
        List<String> colorList = quizReport.colorList(quiz);
        List<String> questionList = quizReport.questionStringList(quiz);
        List<String> answerList = quizReport.UserAnswers(quiz);
        List<String> correctAnswerList = quizReport.correctAnswer(quiz);
        List<String> isCorrectList = quizReport.isCorrectList(quiz);
        List<String> durationList = quizReport.durationList(quiz);
        int wrongAnswers = quizReport.amountCorrectAnswers(quiz);
        double scorePercentage = quizReport.scorePercentage(quiz);

        req.setAttribute("userName", quiz.getUser().getName());
        req.setAttribute("isCorrectList", isCorrectList);
        req.setAttribute("questionList", questionList);
        req.setAttribute("answerList",answerList);
        req.setAttribute("correctAnswerList",correctAnswerList);
        req.setAttribute("durationList",durationList);
        req.setAttribute("totalDuration", StringFormat.durationToString(quizReport.totalDuration(quiz)));
        req.setAttribute("colorList", colorList);
        req.setAttribute("wrongAnswers",wrongAnswers);
        req.setAttribute("scorePercentage", scorePercentage);
        req.getRequestDispatcher("/WEB-INF/pages/quizReport.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/quizReport.jsp").forward(req, resp);
    }
}
