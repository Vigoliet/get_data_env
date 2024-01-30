package com.example.get_data;

import com.example.get_data.models.Post;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiClient {
    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts";

    public static List<Post> getPosts() throws IOException, ParseException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(API_URL);
        CloseableHttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        Gson gson = new Gson();
        Type postListType = new TypeToken<List<Post>>(){}.getType();
        return gson.fromJson(json, postListType);
    }

}
