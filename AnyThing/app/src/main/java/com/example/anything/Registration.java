package com.example.anything;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
    private EditText editName;
    private EditText editPassword;
    private EditText passwordCheck;
    private EditText editEmail;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


    }

    public void buttonGetData(View view) {
        editName = findViewById(R.id.editTextLogin);
        editPassword = findViewById(R.id.editTextPassword);
        passwordCheck=findViewById(R.id.editTextPasswordCheck);
        editEmail = findViewById(R.id.editTextEmail);
        textView=findViewById(R.id.textView);


        String login = editName.getText().toString();
        String password = editPassword.getText().toString();
        String password2=passwordCheck.getText().toString();
        String email = editEmail.getText().toString();



        User user=new User(login,password,password2,email);
        final Intent intent=new Intent(this,MainActivity.class);

        if(!password.equals(password2)){
            AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
            builder.setTitle("Оповещение")
                    .setMessage("Введенные пароли не совпадают.")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();

        }
        else if(!user.isEmailValid(email)){
            AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
            builder.setTitle("Оповещение")
                    .setMessage("Проверьте корректность введенного Email")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else{
            Query queryForRegistration = RetrofitClass.getData().create(Query.class);
            Call<String> call = queryForRegistration.createAccount(user);

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String res=response.body();
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.i("tag","Failed"+t.getMessage());
                }
            });

        }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
