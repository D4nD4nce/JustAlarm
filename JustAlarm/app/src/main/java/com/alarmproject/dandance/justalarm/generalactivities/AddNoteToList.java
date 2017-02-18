package com.alarmproject.dandance.justalarm.generalactivities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import com.alarmproject.dandance.justalarm.R;
import com.alarmproject.dandance.justalarm.database.DBNotes;

public class AddNoteToList extends AppCompatActivity {

    private EditText noteTitle;
    private EditText noteDescription;
    private DBNotes writableDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_to_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        writableDB = new DBNotes(this);
        writableDB.openWrightableDB();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        noteTitle = (EditText) findViewById(R.id.editTextTitle);
        noteDescription = (EditText) findViewById(R.id.editText2);

    }

    private void saveNote() {
        String strTitle = noteTitle.getText().toString();
        String strDescription = noteDescription.getText().toString();
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
