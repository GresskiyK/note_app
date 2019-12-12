package com.example.anything;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Query {
    @GET("/data")
    Call<List<Note>> getNotes();
}
