package com.example.yourway;

import java.util.ArrayList;

public class Note {
    private static ArrayList<Note> listOfNotes=new ArrayList<>();
    private String title;
    private String body;


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public static ArrayList<Note> getListOfNotes(){
        return listOfNotes;
    }

    public Note(String title,String body){
        this.title=title;
        this.body=body;
    }

    public Note(){

    }

    public static void addNote(String title,String body){
        listOfNotes.add(new Note(title,body));
    }

}
