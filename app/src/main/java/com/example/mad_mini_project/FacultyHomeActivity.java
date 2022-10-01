package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyHomeActivity extends AppCompatActivity {
    //defining variable
    private Button stubusdetails,latestmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_home);

        //initializing variable
        stubusdetails = (Button) findViewById(R.id.stubusdetails);
        //onclick
        stubusdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //connection to next page i.e view driver activity
                Intent intent = new Intent(FacultyHomeActivity.this, ViewDriverActivity.class);
                startActivity(intent);
            }
        });
        //initializing variable
        latestmessage = (Button) findViewById(R.id.LatestMessage);
        //onclick
        latestmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //connection to next page i.e view message activity page
                Intent intent = new Intent(FacultyHomeActivity.this, ViewMessageActivity.class);
                startActivity(intent);
            }
        });


    }

}