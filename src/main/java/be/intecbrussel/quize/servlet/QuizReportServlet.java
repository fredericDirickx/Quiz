package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.dao.QuizServiceDao;
import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.QuizReport;
import be.intecbrussel.quize.model.QuizService;
import be.intecbrussel.quize.view.StringFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/report")
public class QuizReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        QuizService quizService = (QuizService) session.getAttribute("quizService");
        QuizReport quizReport = new QuizReport(quizService);
        quizService.setTotalGoodQuestions(quizReport.CorrectAnswers());
        quizService.setTotalPercent(quizReport.getScorePercentage());
        quizService.setTotalTime(quizReport.getTotalDuration());
        session.setAttribute("quizReport", quizReport);
        req.setAttribute("quizReport",quizReport);
        req.setAttribute("totalDuration",StringFormat.durationToString(quizReport.getTotalDuration()));
        QuizServiceDao quizServiceDao = new QuizServiceDao();
        quizServiceDao.create(quizService);
        req.getRequestDispatcher("/WEB-INF/pages/quizReport.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/quizReport.jsp").forward(req, resp);
    }
}
