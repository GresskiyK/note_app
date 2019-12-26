package com.example.anything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.anything.R;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatingNoteForm extends AppCompatActivity{
    private EditText editTitle;
    private EditText editBody;
    private String title;
    private String body;
    private String email;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioGroup radioButton2;
    private RadioGroup radioButton3;
    private SharedPreferences sharedPrefs;
    private int radioButtonId;
    private int colorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_note_form);
        editTitle=findViewById(R.id.editTitle);
        editBody=findViewById(R.id.editBody);
    }

    public void back_to_menu(View view) {
        Intent intent = new Intent(CreatingNoteForm.this, MenuActivity.class);
        startActivity(intent);
    }

    public void addNote(View view) {

//        switch(colorId) {
//            case 1:
//                colorId = 1;
//                break;
//            case 2:
//                colorId = 2;
//                break;
//            case 3:
//                colorId = 3;
//                break;
//            default: colorId = 0;
//                break;
//        }

        if (checkNote()){
            sharedPrefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
            String email=sharedPrefs.getString("email","");
            Note note = new Note(title,body,email);


            Query queryForRegistration = RetrofitClass.getData().create(Query.class);
            Call<String> call = queryForRegistration.createNote(note);

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    Log.i("tag", "post submitted to API." + response.body());
                    Intent intent = new Intent(CreatingNoteForm.this, MenuActivity.class);
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
    public void onBackPressed() {}

    private boolean checkNote(){
        boolean result = false;
        if (!(editTitle.getText().toString().trim().equals("")&(editBody.getText().toString().trim().equals("")))){
            title = editTitle.getText().toString();
            body = editBody.getText().toString();
            result = true;
        }
        return result;
    }
}
