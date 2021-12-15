package pl.coderslab.users;

import entity.User;
import entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        Integer id = -1;
        try {
            id = Integer.parseInt(idString);
            UserDao userDao = new UserDao();
            request.setAttribute("user", userDao.read(id));
            response.getWriter().println(userDao.read(id).getId() +" " + userDao.read(id).getUsername());
            getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
        }catch (NumberFormatException e){
            response.getWriter().println("Incorrect Id");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String idString = request.getParameter("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            int id = Integer.parseInt(idString);
            User user = new User(id, email, userName, password);
            response.getWriter().println(user.toString());
            UserDao userDao = new UserDao();
            userDao.update(user);

            response.sendRedirect("/user/list");

        } catch (NumberFormatException e){
            e.printStackTrace();
        }

        response.getWriter().println("id: " + request.getParameter("id"));
    }
}




