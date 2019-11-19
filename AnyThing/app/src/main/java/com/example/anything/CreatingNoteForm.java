package com.example.anything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anything.R;

public class CreatingNoteForm extends AppCompatActivity implements OnGetData {
    private EditText editTitle;
    private EditText editBody;
    private TextView textView;
    private  String title;
    private String body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_note_form);
        editTitle=findViewById(R.id.editTitle);
        editBody=findViewById(R.id.editBody);
        textView=findViewById(R.id.textView4);
    }

    public void back_to_menu(View view) {
        Intent intent = new Intent(CreatingNoteForm.this, MenuActivity.class);
        startActivity(intent);
    }

    public void addNote(View view) {

//        Intent intent=new Intent(CreatingNoteForm.this,MenuActivity.class);
//
//        if (checkNote()){
//            intent.putExtra("title",title);
//            intent.putExtra("body",body);
//        }
//
//
//
//        startActivity(intent);
        String text=editTitle.getText().toString();
        DownloadData data = new DownloadData(this);
        data.CreateUrl(text);
    }

    @Override
    public void onDataGetListener(String s) {
            textView.setText("Данные"+s);
    }

    @Override
    public void onBackPressed() {
    }
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
