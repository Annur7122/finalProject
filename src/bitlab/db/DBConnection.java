package bitlab.db;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private  static Connection connection;

    static{
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/final_project",
                        "root",
                     "root"
            );

         }catch (Exception e){
             e.printStackTrace();
         }
    }

    public static ArrayList<News> getNews(){
        ArrayList<News> news = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(
                        "" +
                        "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date, n.category_id " +
                        "FROM news AS n " +
                        "INNER JOIN users AS u ON u.id = n.user_id " +
                        "ORDER BY n.post_date DESC"
            );
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                 News news1 = new News();
                 news1.setId((resultSet.getInt("id")));
                 news1.setTitle(resultSet.getString("title"));
                 news1.setContent(resultSet.getString("content"));
                 news1.setUser_id(resultSet.getInt("user_id"));
                 news1.setPost_date((resultSet.getTimestamp("post_date")));
                 news1.setCategory_id((resultSet.getInt("category_id")));




                 news.add(news1);
            }
            for(News n : news) {
                System.out.println(n.getUser_id() + n.getContent() + n.getTitle());
                System.out.println("dfasfd");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return news;
    }

    public static void addNews(News news){
        try{
            PreparedStatement statement = connection.prepareStatement(" " +
                    "INSERT INTO news (post_date, category_id, title, content, user_id) " +
                    "VALUES (NOW(),?,?,?,?)");

            statement.setInt(1, news.getCategory_id());
            statement.setString(2, news.getTitle());
            statement.setString(3, news.getContent());
            statement.setInt(4, news.getUser_id());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static News getNewsById(int id){
        ArrayList<News> news = new ArrayList<>();
        News news1 = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.user_id, u.full_name, n.post_date, n.category_id " +
                    "FROM news n " +
                    "INNER JOIN users u ON u.id = n.user_id " +
                    "WHERE n.id = ?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                news1 = new News();
                news1.setId((resultSet.getInt("id")));
                news1.setTitle(resultSet.getString("title"));
                news1.setContent(resultSet.getString("content"));
                news1.setUser_id(resultSet.getInt("user_id"));
                news1.setPost_date((resultSet.getTimestamp("post_date")));
                news1.setCategory_id((resultSet.getInt("category_id")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return  news1;
    }

    public static void updateNews(News news1) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news " +
                    "SET title = ?, " +
                    "content = ? " +
                    "WHERE id = ?");

            statement.setString(1, news1.getTitle());
            statement.setString(2, news1.getContent());
            statement.setInt(3, news1.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void deleteNews(int id){
            try{
                PreparedStatement statement = connection.prepareStatement("" +
                        "DELETE FROM news WHERE id = ?");

                statement.setInt(1, id);

                statement.executeUpdate();
                statement.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    public static Users getUser(String email) {
        Users user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getString("role_id"));
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(Users user) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, full_name, role_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.setString(4, "2");
            System.out.println(user.getEmail() + " " + user.getRole_id() +  " " + user.getFull_name() + " " + user.getPassword());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void updateUser(Users user1) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users " +
                    "SET full_name = ?, " +
                    "password = ? " +
                    "WHERE id = ?");

            statement.setString(1, user1.getFull_name());
            statement.setString(2, user1.getPassword());
            statement.setInt(3, user1.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addComment(Comments comment){
         try{
             PreparedStatement statement = connection.prepareStatement("" +
                     "INSERT INTO comments (comment, post_date,user_id,news_id) " +
                     "VALUES (?, NOW(),?,?);"
                     );

             statement.setString(1, comment.getComment());
             statement.setInt(2, comment.getUser().getId());
             statement.setInt(3, comment.getNews().getId());

             statement.executeUpdate();
             statement.close();
         }catch (Exception e){
             e.printStackTrace();
         }
    }





    public static ArrayList<Comments> getComments(int newsId){
        ArrayList<Comments> comments = new ArrayList<>();
        try {
           PreparedStatement statement = connection.prepareStatement(
                   "" +
                       "SELECT c.comment, c.id, c.post_date, c.news_id, c.user_id, u.full_name " +
                       "FROM comments c " +
                       "INNER JOIN users u ON u.id = c.user_id " +
                       "WHERE c.news_id = ? "+
                       "ORDER BY c.post_date DESC"
           );

           statement.setInt(1, newsId);

           ResultSet resultSet = statement.executeQuery();



            while (resultSet.next()) {
                Comments comment = new Comments();
                comment.setId(resultSet.getInt("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPost_date(resultSet.getTimestamp("post_date"));

                Users user = new Users();
                user.setId(resultSet.getInt("user_id"));
                user.setFull_name(resultSet.getString("full_name"));
                comment.setUser(user);

                News news = new News();
                news.setId(resultSet.getInt("news_id"));
                comment.setNews(news);

                comments.add(comment);
                System.out.println(comment.getComment());
            }
            for(Comments x : comments) System.out.println("dbc " + x.getComment());
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  comments;

    }

    }

