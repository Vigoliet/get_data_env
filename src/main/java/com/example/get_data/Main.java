package com.example.get_data;

import com.example.get_data.models.Post;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        List<Post> posts = ApiClient.getPosts();
        System.out.println("Fetched " + posts.size() + "posts.");
        // Write some posts to verify
        posts.stream().limit(1).forEach(System.out::println);

    }
}
