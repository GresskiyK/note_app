package com.example.anything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends AppCompatActivity {
    TextView textView;
    EditText editTextLogin;
    EditText editTextPassword;
    SharedPreferences sp;
    private SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }


    public void buttonLogIn(View view) {
        editTextLogin = findViewById(R.id.editTextEmailAuth);
        editTextPassword=findViewById(R.id.editTextPasswordAuth);

        String email=editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();

        sp=getSharedPreferences("prefs",MODE_PRIVATE);
        editor = sp.edit();
        editor.putString("email", email); //
        editor.apply();


        final Intent intent=new Intent(this,MenuActivity.class);
        //intent.putExtra("email",email);


//        UserAuth userAuth = new UserAuth(password);
//        Query queryForRegistration = RetrofitClass.getData().create(Query.class);
//        Call<String> call = queryForRegistration.checkUser(userAuth);

//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                if(response.isSuccessful()) {
//                    String responseFromServer=response.body();
//                    if (responseFromServer.equals("Done")){
                       startActivity(intent);
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("tag","Failed"+t.getMessage());
//            }
//        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
