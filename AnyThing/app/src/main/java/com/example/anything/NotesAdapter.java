package com.example.anything;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView title=holder.itemView.findViewById(R.id.titleOfNote);
        TextView body=holder.itemView.findViewById(R.id.bodyOfNote);
        CardView cardView=holder.itemView.findViewById(R.id.cardViewOfNote);


        title.setText(listOfNotes.get(position).getTitle());
        body.setText(listOfNotes.get(position).getBody());
        int colorID=listOfNotes.get(position).getColorId();
        switch (colorID){
            case 1:
                cardView.setCardBackgroundColor(Color.rgb(64, 212, 93));
                break;
            case 2:
                cardView.setCardBackgroundColor(Color.rgb(253, 253, 72  ));
                break;
            case 3:
                cardView.setCardBackgroundColor(Color.rgb(212, 64, 64));
                break;
                default:
                    cardView.setCardBackgroundColor(R.color.white);
        }

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
