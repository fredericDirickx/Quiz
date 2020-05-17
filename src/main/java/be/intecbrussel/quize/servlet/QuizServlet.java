package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.dao.QuizServiceDao;
import be.intecbrussel.quize.dao.UserDao;
import be.intecbrussel.quize.model.NumberGenerator;
import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.QuizService;
import be.intecbrussel.quize.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/quizStart")
public class QuizServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        if (session.isNew()) {
            resp.sendRedirect("/login.jsp");
        }

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

        String userName = req.getParameter("userName");

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

        List<Question> questionList = quizService.getQuestions();


        session.setAttribute("questionList",questionList);
        session.setAttribute("userName", userName);

        req.getRequestDispatcher("/quiz.jsp").forward(req,resp);

    }

    public boolean isChecked(String string) {
        return string != null;
    }

}
