package com.example.anything;

import com.google.gson.annotations.SerializedName;

public class User {
    private boolean emailValid;
    @SerializedName("login")
    private String login;

    @SerializedName("password")
    private String password;

    @SerializedName("passwordCheck")
    private String passwordCheck;

    @SerializedName("email")
    private String email;


    public User(String login, String password,String passwordCheck, String email) {
        this.login = login;
        this.password = password;
        this.passwordCheck=passwordCheck;
        this.email=email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public boolean isEmailValid (CharSequence email)
    {
        return emailValid= android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }

}
