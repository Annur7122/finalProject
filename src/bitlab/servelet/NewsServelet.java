package bitlab.servelet;


import bitlab.db.DBConnection;
import bitlab.db.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/news")
public class NewsServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<News> news = DBConnection.getNews();
        req.setAttribute("news", news);
        req.getRequestDispatcher("/news.jsp").forward(req, resp);
    }
}