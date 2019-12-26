package com.example.anything;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Note {
    private List<Note> listOfNotes=new ArrayList<>();
    @SerializedName(value="title")
    private String title;
    @SerializedName(value="body")
    private String body;
    @SerializedName(value="colorId")
    private int colorId;
    @SerializedName(value="email")
    private String email;



    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }


    public Note(String title,String body,String email){
        this.title=title;
        this.body=body;
        this.email=email;
        //this.colorId=colorId;
    }

    public Note(){}

//    public void addNote(String title,String body){
//        listOfNotes.add(new Note(title,body,email));
//    }

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


    public int getColorId() {
        return colorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
