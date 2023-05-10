package bitlab.db;

import java.sql.Timestamp;

public class News {
    private int id;
    private Timestamp post_date;
    private int category_id;
    private String title;
    private String content;

    private int user_id;

    public News(){

    }

    public News(int id, Timestamp post_date, int category_id, String title, String content, int user_id) {
        this.id = id;
        this.post_date = post_date;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public News(int id, Timestamp post_date, int category_id, String title, String content) {
        this.id = id;
        this.post_date = post_date;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
