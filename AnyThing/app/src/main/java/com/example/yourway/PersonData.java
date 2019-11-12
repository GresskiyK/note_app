package com.example.yourway;

public class PersonData {
    private String login;
    private String password;
    private String email;
    private boolean emailValid;
    public PersonData(){

    }

    public PersonData(String login,String password,String email){
        this.login=login;
        this.password=password;
        this.email=email;

    }

    public String getLogin(){
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public boolean getEmailValid() {
        return emailValid;
    }

    public void isEmailValid (CharSequence email)
    {
        emailValid= android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }
}
