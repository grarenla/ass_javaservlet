package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/Assignment_war_exploded/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserModel model = new UserModel();
        try {
            User user = model.getUser(username, password);
            if (user == null) {
                req.setAttribute("username", username);
                req.setAttribute("error", "Tài khoản hoặc mật khẩu không chính xác.");
                req.getRequestDispatcher("view/login.jsp").forward(req, resp);
                return;
            }
            req.setAttribute("username", user.getUsername());
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
//            session.setAttribute("username", user.getFullName());
//            session.setAttribute("userId", user.getId());
//            session.setAttribute("role", user.getRole());
            resp.sendRedirect("/Assignment_war_exploded/home");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
