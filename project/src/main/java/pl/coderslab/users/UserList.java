package pl.coderslab.users;

import entity.User;
import entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();

        request.setAttribute("users", users);


        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    }
}
