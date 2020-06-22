package be.intecbrussel.quiz.servlet;

import be.intecbrussel.quiz.dao.impl.UserDaoImpl;
import be.intecbrussel.quiz.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Class.forName;

@WebServlet("/login")
public class QuizLoginServlet extends HttpServlet {


//    @Override
//    public void init() throws ServletException {
//        try {
//            Class.forName("com.mysql.jdbc.driver");
//        }catch (Exception ex){
//            ex.fillInStackTrace();
//        }
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");

        if(userName.equals("")|passWord.equals("")){
            req.setAttribute("wrongPassWord", ", username or password can not be empty");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        }


        User user = new User();
        user.setName(userName);
        user.setPassword(passWord);
        UserDaoImpl userDao = new UserDaoImpl();
        User foundUser = userDao.findByName(user.getName());

        if (foundUser == null) {
           userDao.create(user);
            session.setAttribute("user", user);
           resp.sendRedirect("/quiz/quizSettingsServlet");
        } else {
            if (foundUser.getPassword().equals(passWord)) {
                session.setAttribute("user", foundUser);
                resp.sendRedirect("/quiz/quizSettingsServlet");
            } else {
                req.setAttribute("wrongPassWord", ", Wrong password, please try again");
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            }
        }
    }
}
