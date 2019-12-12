package com.example.anything;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Note {
    private List<Note> listOfNotes=new ArrayList<>();
    @SerializedName(value="email")
    private String title;
    @SerializedName(value="name")
    private String body;

    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

    public Note(String title,String body){
        this.title=title;
        this.body=body;
        //this.colorId=colorId;
    }

    public Note(){}

    public void addNote(String title,String body){
        listOfNotes.add(new Note(title,body));
    }

    public void removeNote(int position){
        listOfNotes.remove(position);
    }

    public void getData(){}

    public List<Note> getListOfNotes() {
        return listOfNotes;
    }

    public void setListOfNotes(List<Note> listOfNotes) {
        this.listOfNotes = listOfNotes;
    }
}
