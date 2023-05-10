package bitlab.servelet;

import bitlab.db.DBConnection;
import bitlab.db.News;
import bitlab.db.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value="/save-user")
public class ToUpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users)  req.getSession().getAttribute("currentUser");

        if(user != null){
            int id = user.getId();
            String fullNameInput = req.getParameter("full_name_input");
            String passwordInput = req.getParameter("password_input");

                Users user1 = DBConnection.getUser(user.getEmail());

                user1.setFull_name(fullNameInput);
                user1.setPassword(passwordInput);

                DBConnection.updateUser(user1);
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user1);
                resp.sendRedirect("/profile");

        }else{
            resp.sendRedirect("/login");
        }
    }
}
