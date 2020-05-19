package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.dao.QuizServiceDao;
import be.intecbrussel.quize.dao.UserDao;
import be.intecbrussel.quize.model.NumberGenerator;
import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.QuizService;
import be.intecbrussel.quize.model.User;
import net.bytebuddy.description.type.TypeDescription;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/quizSettingsServlet")
public class QuizSettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("userName",session.getAttribute("userName"));
        req.getRequestDispatcher("/WEB-INF/pages/quizSettings.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        NumberGenerator numberGenerator = new NumberGenerator(
                0,
                11,
                0,
                11);

        QuizService quizService = new QuizService();

        User user = (User) session.getAttribute("user");
        quizService.setUser(user);

        boolean isAddition = isChecked(req.getParameter("addition"));
        boolean isSubtraction = isChecked(req.getParameter("subtraction"));
        boolean isMultiplication = isChecked(req.getParameter("multiplication"));
        boolean isDivision = isChecked(req.getParameter("division"));

        int amount = Integer.parseInt(req.getParameter("amount"));

        double firstNumberLowerBound = Double.parseDouble(req.getParameter("firstNumberLowerBound"));
        double firstNumberUpperBound = Double.parseDouble(req.getParameter("firstNumberUpperBound"));
        double secondNumberLowerBound = Double.parseDouble(req.getParameter("secondNumberLowerBound"));
        double secondNumberUpperBound = Double.parseDouble(req.getParameter("secondNumberUpperBound"));

        quizService.setIsAddition(isAddition);
        quizService.setIsSubtraction(isSubtraction);
        quizService.setIsDivision(isDivision);
        quizService.setIsMultiplication(isMultiplication);

        quizService.setAmountQuestions(amount);

        numberGenerator.setLowerBoundFirstNumber(firstNumberLowerBound);
        numberGenerator.setUpperBoundFirstNumber(firstNumberUpperBound);
        numberGenerator.setLowerBoundSecondNumber(secondNumberLowerBound);
        numberGenerator.setUpperBoundSecondNumber(secondNumberUpperBound);
        quizService.setNumberGenerator(numberGenerator);

        quizService.createQuiz();


        session.setAttribute("quizService",quizService);
        session.setAttribute("index", 0);

        resp.sendRedirect("/quiz/quizAdmin");
    }

    public boolean isChecked(String string) {
        return string != null;
    }

}
