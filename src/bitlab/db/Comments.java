package bitlab.db;

import java.sql.Timestamp;

public class Comments {
    private int id;
    private String comment;
    private Timestamp post_date;
    private Users user;
    private News news;
    private int user_id;
    private int news_id;

    public Comments(){

    }

    public Comments(int id, String comment, Timestamp post_date, int user_id, int news_id) {
        this.id = id;
        this.comment = comment;
        this.post_date = post_date;
        this.user_id = user_id;
        this.news_id = news_id;
    }

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }
}
