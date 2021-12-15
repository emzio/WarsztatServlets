package pl.coderslab.users;

import entity.User;
import entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        try {
            int id = Integer.parseInt(idString);
            UserDao userDao = new UserDao();

            request.setAttribute("user", userDao.read(id));
            getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
