package be.intecbrussel.quize.servlet;

import be.intecbrussel.quize.dao.UserDao;
import be.intecbrussel.quize.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class QuizLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");


        User user = new User();
        user.setName(userName);
        user.setPassword(passWord);
        UserDao userDao = new UserDao();
        User foundUser = userDao.findByName(user.getName());
        session.setAttribute("userName", user.getName());

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
                resp.sendRedirect("/login");
            }
        }
    }
}
