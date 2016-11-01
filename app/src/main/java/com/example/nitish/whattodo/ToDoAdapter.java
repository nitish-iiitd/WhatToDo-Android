package com.example.nitish.whattodo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nitish on 31/10/16.
 */

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {

    private List<ToDo> todoList;


    public ToDoAdapter(List<ToDo> todoList) {
        this.todoList = todoList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, details, importance;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

            //details = (TextView) view.findViewById(R.id.details);
            //importance = (TextView) view.findViewById(R.id.importance);

        }



    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ToDo todo = todoList.get(position);
        holder.title.setText(todo.getTitle());


        //holder.details.setText(todo.getDetails());
        //holder.importance.setText(todo.getImportance());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
