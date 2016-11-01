package com.example.nitish.whattodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayToDoActivity extends AppCompatActivity {

    String title;
    String details;
    TextView titletext;
    TextView detailstext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_to_do);
        titletext = (TextView)findViewById(R.id.title);
        detailstext = (TextView)findViewById(R.id.details);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                title = null;
                details = null;
            } else {
                title = extras.getString("todotitle");
                details = extras.getString("tododetails");
            }
        } else {
            title = (String) savedInstanceState.getSerializable("todotitle");
            details = (String) savedInstanceState.getSerializable("tododetails");
        }

        titletext.setText(title);
        detailstext.setText(details);

    }
}
