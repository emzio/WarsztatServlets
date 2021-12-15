package pl.coderslab.users;

import entity.User;
import entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("user/add");
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String surname = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(email,surname, password);

        response.getWriter().println(user.toString());
        UserDao userDao = new UserDao();
        User userAdded = userDao.create(user);
        response.getWriter().println(userAdded);
        response.sendRedirect("/user/list");
    }
}
