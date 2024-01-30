package com.example.get_data.services;

import com.example.get_data.models.Post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import io.github.cdimascio.dotenv.Dotenv;


public class DatabaseSaver {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String DB_URL = "jdbc:mysql://localhost:3306/posts";
    private static final String USER = dotenv.get("STRING1");
    private static final String PASS = dotenv.get("STRING2");
    public static void savePostsToDatabase(List<Post> posts){
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO posts (userId, id, title, body) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            for (Post post : posts) {
                statement.setInt(1, post.getUserId());
                statement.setInt(2, post.getId());
                statement.setString(3, post.getTitle());
                statement.setString(4, post.getBody());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
