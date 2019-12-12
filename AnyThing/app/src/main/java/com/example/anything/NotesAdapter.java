package com.example.anything;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder>{
    private List<Note> listOfNotes;
    private OnNoteClickListener onNoteClickListener;

    public NotesAdapter(List<Note> list){
        this.listOfNotes=list;
    }

    interface OnNoteClickListener{
        void clickedNote(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_note_form,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView title=holder.itemView.findViewById(R.id.titleOfNote);
        TextView body=holder.itemView.findViewById(R.id.bodyOfNote);

        title.setText(listOfNotes.get(position).getTitle());
        body.setText(listOfNotes.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(listOfNotes==null){
            return 0;
        }
        else{
            return listOfNotes.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onNoteClickListener!=null){
                        onNoteClickListener.clickedNote(getAdapterPosition());
                    }
                }
            });
        }
    }
}
