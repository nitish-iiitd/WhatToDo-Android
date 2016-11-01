package com.example.nitish.whattodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
    }

    public void addToDo(View v)
    {

        EditText titletext = (EditText)findViewById(R.id.title);
        String title = titletext.getText().toString();

        EditText detailstext = (EditText)findViewById(R.id.details);
        String details = detailstext.getText().toString();

        ToDo todo = new ToDo(title,details,5);

        DatabaseHandler dh = new DatabaseHandler(this);
        dh.addToDo(todo);
        Toast.makeText(this,"ToDo Successfully added.",Toast.LENGTH_SHORT);

        Intent mainscreen = new Intent(this,MainActivity.class);
        startActivity(mainscreen);
    }
}
