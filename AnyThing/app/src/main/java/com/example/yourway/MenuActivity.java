package com.example.yourway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    private ArrayList<Note> notes=new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView=findViewById(R.id.recyclerView);
        notes.add(new Note("jhjjhghhfhgfhgfgfdfdfdfff","Игра в 12.00"));
        notes.add(new Note("Волейбол","Игра в 12.00"));
        notes.add(new Note("Волейбол","Игра в 12.00"));
        notes.add(new Note("Волейбол","Игра в 12.00"));
        notes.add(new Note("Волейбол","Игра в 12.00"));
        notes.add(new Note("Волейбол","Игра в 12.00"));

        NotesAdapter adapter=new NotesAdapter(notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



    }


    public void createNote(View view) {
        Intent intent = new Intent(MenuActivity.this, CreatingNoteForm.class);
        startActivity(intent);
    }
}
