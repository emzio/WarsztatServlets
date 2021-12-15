package pl.coderslab.users;

import entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id;
        try {
            id = Integer.parseInt(idString);
            UserDao userDao = new UserDao();

            userDao.delete(id);
//            request.setAttribute("user", userDao.read(id));
//            response.getWriter().println(userDao.read(id).getId() +" " + userDao.read(id).getUsername());
//            getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
            response.sendRedirect("/user/list");
        }catch (NumberFormatException e){
            response.getWriter().println("Incorrect Id");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
