package com.example.anything;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Query {
    @GET("/notes")
    Call<List<Note>> getNotes();
    @POST("/addUser")
    Call<User> createAccount(@Body  User user);
}
