package com.alarmproject.dandance.justalarm.generalactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.alarmproject.dandance.justalarm.R;
import com.alarmproject.dandance.justalarm.database.DBNotes;
import com.alarmproject.dandance.justalarm.database.ObjectItem;

public class AddNoteToList extends AppCompatActivity {

    public static final String strAddNoteKey = "Id_For_AddNote_Update";

    private EditText noteTitle;
    private EditText noteDescription;
    private DBNotes writableDB;
    private long currentID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_to_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });
        //
        try { currentID = getIntent().getExtras().getLong(strAddNoteKey); }
        catch (Exception r) {
            //Toast.makeText(this, " что т не так" + r ,Toast.LENGTH_LONG).show();
        }
        //
        writableDB = new DBNotes(this);
        writableDB.openWrightableDB();
        //
        noteTitle = (EditText) findViewById(R.id.editTextTitle);
        noteDescription = (EditText) findViewById(R.id.editText2);
        //
        if (currentID != 0) {
            ObjectItem currentItem = new ObjectItem();
            currentItem.setInfo(writableDB.selectRecNotesTab(currentID));

            noteTitle.setText(currentItem.getTitle());
            noteDescription.setText(currentItem.getStrDescription());
        }
    }

    private void saveNote() {
        String strTitle = noteTitle.getText().toString();
        String strDescription = noteDescription.getText().toString();
        int headLength = strTitle.length();

        if (headLength == 0){
            Toast.makeText(this, "Пожалуйста, введите название заметки", Toast.LENGTH_SHORT).show();
            return;
        }

        if (currentID != 0) {
            writableDB.btnUpdNotesTab(currentID, strTitle, strDescription);
        } else {
            writableDB.addRecNotesTab(strTitle, strDescription, R.drawable.check);
        }

        Toast.makeText(this, "Заметка сохранена", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this, NotesList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        writableDB.closeDB();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        writableDB.closeDB();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        writableDB.closeDB();
    }


}
