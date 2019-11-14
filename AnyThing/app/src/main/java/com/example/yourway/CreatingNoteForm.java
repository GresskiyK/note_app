package com.example.yourway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreatingNoteForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_note_form);
    }

    public void back_to_menu(View view) {
        Intent intent = new Intent(CreatingNoteForm.this, MenuActivity.class);
        startActivity(intent);
    }
}
