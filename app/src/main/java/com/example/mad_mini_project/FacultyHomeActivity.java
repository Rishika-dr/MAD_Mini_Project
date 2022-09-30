package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyHomeActivity extends AppCompatActivity {
    private Button stubusdetails,latestmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_home);


        stubusdetails = (Button) findViewById(R.id.stubusdetails);
        stubusdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyHomeActivity.this, ViewDriverActivity.class);
                startActivity(intent);
            }
        });

        latestmessage = (Button) findViewById(R.id.LatestMessage);
        latestmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyHomeActivity.this, ViewMessageActivity.class);
                startActivity(intent);
            }
        });


    }

}