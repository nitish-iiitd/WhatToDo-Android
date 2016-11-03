package com.example.nitish.whattodo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DisplayVPActivity extends AppCompatActivity {

   // public List<ToDo> todoList = new ArrayList<>();
    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_vp);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                position = 0;
            } else {
                //System.out.println("title : " + extras.getString("todotitle"));
                //System.out.println("position : " + extras.getString("position"));
                position = extras.getInt("position");

            }
        } else {
            position =  Integer.parseInt((String)savedInstanceState.getSerializable("position"));

        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
        viewPager.setCurrentItem(position);

//        DatabaseHandler dh = new DatabaseHandler(this);
//        todoList = dh.getAllToDos();
    }

    public void goToHome(View v)
    {
        Intent homescreen = new Intent(this,MainActivity.class);
        startActivity(homescreen);
    }
}
