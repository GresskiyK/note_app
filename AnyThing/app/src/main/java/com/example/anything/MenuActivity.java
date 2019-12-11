package com.example.anything;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anything.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Bundle b = getIntent().getExtras();

        Note note = new Note();

        if (b!=null) {
            note=(Note)b.getSerializable(Note.class.getSimpleName());
            String title = note.getTitle();
            String body = note.getBody();
            note.addNote(title,body);
        }

        final NotesAdapter adapter = new NotesAdapter(note.getListOfNotes());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        final Note finalNote = note;
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                finalNote.removeNote(viewHolder.getAdapterPosition());
                adapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void moveToCreatingNoteForm(View view) {
        Intent intent = new Intent(MenuActivity.this, CreatingNoteForm.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
    }
}