package com.example.anything;

import com.google.gson.annotations.SerializedName;

public class UserAuth {
//    @SerializedName("password")
//    private String password;

    @SerializedName("email")
    private String email;

//    public UserAuth(String email,String password) {
//
//        this.email=email;
//        this.password=password;
//    }
    public UserAuth(String email) {

        this.email=email;

    }
}
