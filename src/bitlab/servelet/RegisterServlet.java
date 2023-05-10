package bitlab.servelet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import bitlab.db.DBConnection;
import bitlab.db.Users;

import java.io.IOException;

@WebServlet(value = "/registration")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email_input");
        String password = request.getParameter("password_input");
        String rePassword = request.getParameter("re_password_input");
        String fullName = request.getParameter("full_name_input");

        Users user = DBConnection.getUser(email);

        if(user==null){
            if(password.equals(rePassword)){

                Users createUser = new Users();
                createUser.setEmail(email);
                createUser.setPassword(password);
                createUser.setFull_name(fullName);
                createUser.setRole_id("2");

                DBConnection.addUser(createUser);
                response.sendRedirect("/registration?success");

            }else{
                response.sendRedirect("/registration?passworderror");
            }
        }else{
            response.sendRedirect("/registration?emailerror");
        }
    }

}