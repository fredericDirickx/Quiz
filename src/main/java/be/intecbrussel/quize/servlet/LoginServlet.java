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
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.isNew()) {
            resp.sendRedirect("/quiz/login.jsp");
        }else {
            req.setAttribute("userName",session.getAttribute("userName"));
            req.setAttribute("passWord",session.getAttribute("passWord"));
            req.getRequestDispatcher("/quizSettings.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        User user = new User();
        user.setName(userName);
        user.setPassword(passWord);
        UserDao userDao = new UserDao();
        User foundUser = userDao.findByName(user.getName());
        req.setAttribute("userName",user.getName());

        if(foundUser==null){
            userDao.create(user);
            req.getRequestDispatcher("/quizSettings.jsp").forward(req,resp);
        }else {
            if(foundUser.getPassword().equals(passWord)){
                req.getRequestDispatcher("/quizSettings.jsp").forward(req,resp);
            }else {
                req.setAttribute("wrongPassWord",", Wrong password, please try again");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }
}
