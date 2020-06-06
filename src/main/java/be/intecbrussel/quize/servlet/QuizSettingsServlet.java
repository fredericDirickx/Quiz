package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.model.Quiz;
import be.intecbrussel.quize.model.QuizSettings;
import be.intecbrussel.quize.model.User;
import be.intecbrussel.quize.service.QuizService;
import be.intecbrussel.quize.service.impl.QuizServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/quizSettingsServlet")
public class QuizSettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            resp.sendRedirect("login");
        } else {
            User user = (User) session.getAttribute("user");
            req.setAttribute("userName", user.getName());
            req.getRequestDispatcher("/WEB-INF/pages/quizSettings.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Quiz quiz = new Quiz();
        OperandBoundaries boundaries = new OperandBoundaries();
        QuizSettings settings = new QuizSettings();
        QuizService quizService = new QuizServiceImpl();

        User user = (User) session.getAttribute("user");
        quiz.setUser(user);

        int amount = Integer.parseInt(req.getParameter("amount"));
        quiz.setAmountQuestions(amount);

        settings.setAddition(isChecked(req.getParameter("addition")));
        settings.setSubtraction(isChecked(req.getParameter("subtraction")));
        settings.setMultiplication(isChecked(req.getParameter("multiplication")));
        settings.setDivision(isChecked(req.getParameter("division")));
        settings.setShuffled(isChecked(req.getParameter("shuffle")));
        quiz.setSettings(settings);



        boundaries.setLowerBoundFirstNumber(new BigDecimal(req.getParameter("firstNumberLowerBound")));
        boundaries.setUpperBoundFirstNumber(new BigDecimal(req.getParameter("firstNumberUpperBound")));
        boundaries.setLowerBoundSecondNumber(new BigDecimal(req.getParameter("secondNumberLowerBound")));
        boundaries.setUpperBoundSecondNumber(new BigDecimal(req.getParameter("secondNumberUpperBound")));
        quiz.setBoundaries(boundaries);

        quiz.setQuestions(quizService.createQuestions(quiz));

        session.setAttribute("quiz", quiz);
        session.setAttribute("index", 0);

        resp.sendRedirect("/quiz/quizAdmin");
    }

    public boolean isChecked(String string) {
        return string != null;
    }

}
