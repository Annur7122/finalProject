package bitlab.servelet;

import bitlab.db.Comments;
import bitlab.db.DBConnection;
import bitlab.db.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/news-details")
public class NewsDetailsServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        News news = DBConnection.getNewsById(id);
        request.setAttribute("news", news);

        if(news != null){
            ArrayList<Comments> comments = DBConnection.getComments(id);

            request.setAttribute("comments", comments);
        }

        request.getRequestDispatcher("/newsdetails.jsp").forward(request,response);
    }
}
