package com.example.nitish.whattodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ToDo> todoList = new ArrayList<>();
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

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ToDoAdapter(todoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

        //prepareToDoData();
    }

    private void prepareToDoData() {
        ToDo todo = new ToDo("Mad Max: Fury Road", "Action & Adventure",3);
        todoList.add(todo);

        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);
        todo = new ToDo("MC", "Action & Adventure",3);
        todoList.add(todo);


        System.out.println("todo size:"+todoList.size());


        mAdapter.notifyDataSetChanged();
    }

    public void goToAddToDo(View v)
    {
        Intent addscreen = new Intent(this,AddToDoActivity.class);
        startActivity(addscreen);
    }
}
