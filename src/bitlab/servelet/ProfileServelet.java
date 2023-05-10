package bitlab.servelet;


import bitlab.db.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value="/profile")
public class ProfileServelet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users currentUser = (Users)request.getSession().getAttribute("currentUser");
        if(currentUser != null) {
            request.getRequestDispatcher("profile.jsp").forward(request,response);
        }else{
            response.sendRedirect("/login");
        }

    }
}
