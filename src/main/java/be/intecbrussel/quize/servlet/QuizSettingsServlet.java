//package be.intecbrussel.quize.servlet;
//
//import be.intecbrussel.quize.service.OperandServiceImplV01;
//import be.intecbrussel.quize.service.QuizService;
//import be.intecbrussel.quize.model.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/quizSettingsServlet")
//public class QuizSettingsServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        if(session.isNew()){
//            resp.sendRedirect("login");
//        }else {
//            req.setAttribute("userName", session.getAttribute("userName"));
//            req.getRequestDispatcher("/WEB-INF/pages/quizSettings.jsp").forward(req, resp);
//        }
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//
//        OperandServiceImplV01 numberGenerator = new OperandServiceImplV01(
//                0,
//                11,
//                0,
//                11);
//
//        QuizService quizService = new QuizService();
//
//        User user = (User) session.getAttribute("user");
//        quizService.setUser(user);
//
//        boolean isAddition = isChecked(req.getParameter("addition"));
//        boolean isSubtraction = isChecked(req.getParameter("subtraction"));
//        boolean isMultiplication = isChecked(req.getParameter("multiplication"));
//        boolean isDivision = isChecked(req.getParameter("division"));
//
//        int amount = Integer.parseInt(req.getParameter("amount"));
//
//        double firstNumberLowerBound = Double.parseDouble(req.getParameter("firstNumberLowerBound"));
//        double firstNumberUpperBound = Double.parseDouble(req.getParameter("firstNumberUpperBound"));
//        double secondNumberLowerBound = Double.parseDouble(req.getParameter("secondNumberLowerBound"));
//        double secondNumberUpperBound = Double.parseDouble(req.getParameter("secondNumberUpperBound"));
//
//        quizService.setIsAddition(isAddition);
//        quizService.setIsSubtraction(isSubtraction);
//        quizService.setIsDivision(isDivision);
//        quizService.setIsMultiplication(isMultiplication);
//
//        quizService.setAmountQuestions(amount);
//
//        numberGenerator.setLowerBoundFirstNumber(firstNumberLowerBound);
//        numberGenerator.setUpperBoundFirstNumber(firstNumberUpperBound);
//        numberGenerator.setLowerBoundSecondNumber(secondNumberLowerBound);
//        numberGenerator.setUpperBoundSecondNumber(secondNumberUpperBound);
//        quizService.setNumberGenerator(numberGenerator);
//
//        quizService.createQuestions();
//
//
//        session.setAttribute("quizService",quizService);
//        session.setAttribute("index", 0);
//
//        resp.sendRedirect("/quiz/quizAdmin");
//    }
//
//    public boolean isChecked(String string) {
//        return string != null;
//    }
//
//}
