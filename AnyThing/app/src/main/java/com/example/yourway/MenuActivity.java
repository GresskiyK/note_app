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
        Bundle b=getIntent().getExtras();

        if(b!=null){
            String title=b.getString("title");
            String body=b.getString("body");
            Note.getListOfNotes().add(new Note(title,body));
        }

        NotesAdapter adapter=new NotesAdapter(Note.getListOfNotes());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void moveToCreatingNoteForm(View view) {
        Intent intent = new Intent(MenuActivity.this, CreatingNoteForm.class);
        startActivity(intent);
    }
}
