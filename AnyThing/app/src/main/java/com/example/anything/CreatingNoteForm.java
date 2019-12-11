package com.example.anything;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.anything.R;

import java.io.Serializable;

public class CreatingNoteForm extends AppCompatActivity implements OnGetData {
    private EditText editTitle;
    private EditText editBody;
    private  String title;
    private String body;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioGroup radioButton2;
    private RadioGroup radioButton3;
    private BottomSheetDialog sheetDialog;
    private int radioButtonId;
    private int colorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_note_form);
        editTitle=findViewById(R.id.editTitle);
        editBody=findViewById(R.id.editBody);
    }

    public void back_to_menu(View view) {
        Intent intent = new Intent(CreatingNoteForm.this, MenuActivity.class);
        startActivity(intent);
    }

    public void addNote(View view) {

        Intent intent=new Intent(CreatingNoteForm.this,MenuActivity.class);

//        switch(colorId) {
//            case 1:
//                colorId = 1;
//                break;
//            case 2:
//                colorId = 2;
//                break;
//            case 3:
//                colorId = 3;
//                break;
//            default: colorId = 0;
//                break;
//        }

        if (checkNote()){
            Note note=new Note(title,body);
            intent.putExtra(Note.class.getSimpleName(),note);
        }
        startActivity(intent);
    }

    @Override
    public void onDataGetListener(String s) {}

    @Override
    public void onBackPressed() {
    }
    private boolean checkNote(){
        boolean result = false;
        if (!(editTitle.getText().toString().trim().equals("")&(editBody.getText().toString().trim().equals("")))){
            title = editTitle.getText().toString();
            body = editBody.getText().toString();
            result = true;
        }
        return result;
    }

    public void openBottomSheet(View view) {
        BottomSheetDialog sheetDialog=new BottomSheetDialog();
        sheetDialog.show(getSupportFragmentManager(),"bottom sheet");
    }
}
