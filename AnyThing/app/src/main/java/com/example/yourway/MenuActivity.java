package com.example.yourway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView=findViewById(R.id.recyclerView);
        Note note=new Note();
        Bundle b=getIntent().getExtras();

        if(b!=null){

            note.getListOfNotes().add(new Note(b.getString("title"),b.getString("body")));

        }


        NotesAdapter adapter=new NotesAdapter(note.getListOfNotes());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void moveToCreatingNoteForm(View view) {
        Intent intent = new Intent(MenuActivity.this, CreatingNoteForm.class);
        startActivity(intent);
    }
}
