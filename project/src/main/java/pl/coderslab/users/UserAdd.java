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
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().println("user/add");

//        if(request.getParameter("error").equals("email")){
//            System.out.println("ustawianie error w GET");   // do usunięcia - kontrola
//            request.setAttribute("error", "email");
//        }
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String surname = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(email,surname, password);

        response.getWriter().println(user.toString());
        UserDao userDao = new UserDao();

//        emailRepeat(user, userDao);
//
//        User userAdded = userDao.create(user);
//        response.getWriter().println(userAdded);

//        response.sendRedirect("/user/list");


//        początek zmian faza2
        if(!emailRepeat(user,userDao)){
            userDao.create(user);
            response.sendRedirect("/user/list");

        } else {
            response.sendRedirect("/user/emailRepeat");
        }
    }

    protected static boolean emailRepeat (User user, UserDao userDao){
        User[] users = userDao.findAll();
        if (users!=null){
            for (User singleUser : users) {
                System.out.println("singleUser: " + singleUser.getEmail() + "userAdded: " + user.getEmail());
                if(singleUser.getEmail().equals(user.getEmail())){

                    System.out.println("email powtórka");
                    return true;
                }
            }
        }
        System.out.println("email bez powtórek");
        return false;
    }
}
