package com.example.mad_mini_project;

import static com.example.mad_mini_project.Constants.TOPIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;

public class StudentHomeActivity extends AppCompatActivity {
    //initializing variable
    private Button stubusdetails,latestmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        //connecting message to firebase
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        stubusdetails = (Button) findViewById(R.id.stubusdetails);
        stubusdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //connection to next page
                Intent intent = new Intent(StudentHomeActivity.this, ViewDriverActivity.class);
                startActivity(intent);
            }
        });

        latestmessage = (Button) findViewById(R.id.LatestMessage);
        //onclick listener
        latestmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //connection to next page
                Intent intent = new Intent(StudentHomeActivity.this, ViewMessageActivity.class);
                startActivity(intent);
            }
        });

    }

}