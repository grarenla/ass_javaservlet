package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/Assignment_war_exploded/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserModel userModel = new UserModel();
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setFullName(req.getParameter("fullName"));

        if (!user.isValid()) {
            req.setAttribute("errors", user.getErrors());
            req.setAttribute("user", user);
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        userModel.insert(user);
        resp.sendRedirect("/Assignment_war_exploded/login");
    }
}
