package com.example.anything;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anything.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MenuActivity extends AppCompatActivity {
    Note note = new Note();
    RecyclerView recyclerView;
    TextView textView;
    private SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = findViewById(R.id.recyclerView);
        textView=findViewById(R.id.textViewTitle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPrefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String email=sharedPrefs.getString("email","");
        Log.i("email",email);
        UserAuth userAuth=new UserAuth(email);

        Query queryForNotes = RetrofitClass.getData().create(Query.class);
        Call<List<Note>> call = queryForNotes.getNotes(userAuth);
        call.enqueue(new Callback<List<Note>>() {
            @Override
            public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {
                List<Note> notes=response.body();
                final NotesAdapter adapter = new NotesAdapter(notes);
                recyclerView.setLayoutManager(new LinearLayoutManager(MenuActivity.this));
                recyclerView.setAdapter(adapter);
                note.setListOfNotes(notes);
                ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        note.removeNote(viewHolder.getAdapterPosition());
                        adapter.notifyDataSetChanged();
                    }
                });
                itemTouchHelper.attachToRecyclerView(recyclerView);
            }

            @Override
            public void onFailure(Call<List<Note>> call, Throwable t) {

            }
        });

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