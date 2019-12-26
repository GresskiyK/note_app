package com.example.anything;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Query {
    @POST("/notes")
    Call<List<Note>> getNotes(@Body UserAuth userAuth);
    @POST("/addUser")
    Call<String> createAccount(@Body  User user);
    @POST("/addNote")
    Call<String> createNote(@Body  Note note);
    @POST("/userAuth")
    Call<String> checkUser(@Body  UserAuth userAuth);
}
