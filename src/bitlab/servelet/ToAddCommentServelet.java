package bitlab.servelet;


import bitlab.db.Comments;
import bitlab.db.DBConnection;
import bitlab.db.News;
import bitlab.db.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.security.cert.CertPath;

@WebServlet(value="/add-comment")
public class ToAddCommentServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users)  req.getSession().getAttribute("currentUser");

        if(user != null){
            String commentText = req.getParameter("comment_input");
            int newsId = Integer.parseInt(req.getParameter("news_id_input"));

            News news = DBConnection.getNewsById(newsId);

            if(news != null){
                Comments comment = new Comments();
                comment.setNews(news);
                comment.setUser(user);
                comment.setComment(commentText);

                DBConnection.addComment(comment);

                resp.sendRedirect("/news-details?id="+newsId);

            }else{
                resp.sendRedirect("/");
            }


        }else{
            resp.sendRedirect("/login");
        }
    }
}
