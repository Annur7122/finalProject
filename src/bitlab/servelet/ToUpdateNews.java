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

@WebServlet(value="/save-news")
public class ToUpdateNews extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users)  req.getSession().getAttribute("currentUser");

        if(user != null){

            int id = Integer.parseInt(req.getParameter("id_input"));
            String title = req.getParameter("title_input");
            String content = req.getParameter("content_input");




            News news = DBConnection.getNewsById(id);

            if(news != null) {
                news.setTitle(title);
                news.setContent(content);


                DBConnection.updateNews(news);
                resp.sendRedirect("/news-details?id="+ id);
            }else {
                resp.sendRedirect("/");
            }


        }else{
            resp.sendRedirect("/login");
        }
    }
}
