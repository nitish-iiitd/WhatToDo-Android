package com.example.nitish.whattodo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    public static List<ToDo> todoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ToDoAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseHandler dh = new DatabaseHandler(this);
        todoList = dh.getAllToDos();

        System.out.println("==========================todolist size : "+todoList.size());

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ToDoAdapter(todoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {





                //ToDo todo = todoList.get(position);

                    // Intent displayscreen = new Intent(getApplicationContext(),DisplayToDoActivity.class);
                    Intent displayscreen = new Intent(getApplicationContext(), DisplayVPActivity.class);
                    //displayscreen.putExtra("todotitle", todo.getTitle());
                    //displayscreen.putExtra("tododetails", todo.getDetails());
                    displayscreen.putExtra("position", position);
                    startActivity(displayscreen);

                    //Toast.makeText(getApplicationContext(), todo.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                //Toast.makeText(getApplicationContext(), " Long click is selected!", Toast.LENGTH_SHORT).show();
                final ToDo todo = todoList.get(position);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Are you sure you want to delete this todo task : "+todo.getTitle());

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        DatabaseHandler dh = new DatabaseHandler(MainActivity.this);
                        int deleted = dh.deleteToDo(todo.getTitle());
                        if(deleted >0 )
                        {
                            Toast.makeText(getApplicationContext(),"ToDo Deleted",Toast.LENGTH_LONG).show();
                        }
                       else
                        {
                            Toast.makeText(getApplicationContext(),"Error in deleting!",Toast.LENGTH_LONG).show();
                        }
                        Intent mainscreen = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(mainscreen);
                    }
                });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                        //Toast.makeText(getApplicationContext(),"You clicked yes button",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }));
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
        //prepareToDoData();
    }

    private void prepareToDoData() {
        ToDo todo = new ToDo("Mad Max: Fury Road", "Action & Adventure", 3);
        todoList.add(todo);

        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure", 3);
        todoList.add(todo);
        System.out.println("todo size:" + todoList.size());
        mAdapter.notifyDataSetChanged();
    }

    public void goToAddToDo(View v) {
        Intent addscreen = new Intent(this, AddToDoActivity.class);
        startActivity(addscreen);
    }

//    public void todoDone(View v) {
//
//        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show();
//
//    }
}
