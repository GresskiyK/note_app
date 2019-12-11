package com.example.anything;

import java.io.Serializable;
import java.util.ArrayList;

public class Note implements Serializable {
    private static ArrayList<Note> listOfNotes=new ArrayList<>();
    private String title;
    private String body;
//    private int colorId;


    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }

//    public int getColorId() {
//        return colorId;
//    }

    public ArrayList<Note> getListOfNotes(){
        return listOfNotes;
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

}
