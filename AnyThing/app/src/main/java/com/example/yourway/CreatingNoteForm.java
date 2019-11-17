package com.example.yourway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class CreatingNoteForm extends AppCompatActivity {
    private EditText editTitle;
    private EditText editBody;

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

        Intent intent=new Intent(CreatingNoteForm.this,MenuActivity.class);
        intent.putExtra("title",editTitle.getText().toString());
        intent.putExtra("body",editBody.getText().toString());

        startActivity(intent);
    }
}
