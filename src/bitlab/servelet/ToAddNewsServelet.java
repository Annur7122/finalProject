package bitlab.servelet;


import bitlab.db.DBConnection;
import bitlab.db.News;
import bitlab.db.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/add-news")
public class ToAddNewsServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users)  req.getSession().getAttribute("currentUser");
        if(user != null){
            String title = req.getParameter("title_input");
            String content = req.getParameter("content_input");

            News news = new News();
            news.setTitle(title);
            news.setContent(content);
            news.setUser_id(user.getId());

            DBConnection.addNews(news);
            resp.sendRedirect("/add-news-page");


        }else{
            resp.sendRedirect("/login");
        }
    }
}
