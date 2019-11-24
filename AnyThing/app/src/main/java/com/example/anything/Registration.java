package com.example.anything;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.anything.R;

public class Registration extends AppCompatActivity {
    private EditText editName;
    private EditText editPassword;
    private EditText passwordCheck;
    private EditText editEmail;

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


        String name = editName.getText().toString();
        String password = editPassword.getText().toString();
        String password2=passwordCheck.getText().toString();
        String email = editEmail.getText().toString();
        CharSequence chars=email;
        PersonData data =new PersonData();
        data.isEmailValid(chars);

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
//        else if(!data.getEmailValid()){
//            AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
//            builder.setTitle("Оповещение")
//                    .setMessage("Проверьте корректность введенного Email")
//                    .setCancelable(false)
//                    .setNegativeButton("ОК",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//            AlertDialog alert = builder.create();
//            alert.show();
//        }
        else{
            Intent intent = new Intent(Registration.this, MenuActivity.class);
            startActivity(intent);

        }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
