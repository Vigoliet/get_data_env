package com.example.get_data;

import com.example.get_data.models.Post;
import com.example.get_data.services.ApiClient;
import com.example.get_data.services.DatabaseSaver;
import com.example.get_data.services.FileSaver;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        List<Post> posts = ApiClient.getPosts();
        System.out.println("Fetched " + posts.size() + "posts.");
        // Write some posts to verify
        posts.stream().limit(1).forEach(System.out::println);

        FileSaver.savePostToFile(posts, "posts.txt");
        DatabaseSaver.savePostsToDatabase(posts);
    }
}
