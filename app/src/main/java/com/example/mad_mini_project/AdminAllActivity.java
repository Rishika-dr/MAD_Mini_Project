package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminAllActivity extends AppCompatActivity {
    private Button SendMessage, AddDriver, ViewDriver,AddFaculty,ViewFaculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_all);

        SendMessage = (Button) findViewById(R.id.SendMessage);
        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminAllActivity.this, SendMessageActivity.class);
                startActivity(intent);
            }
        });
        AddDriver = (Button) findViewById(R.id.AddDriver);
        AddDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAllActivity.this, AddDriverActivity.class);
                startActivity(intent);
            }
        });
        ViewDriver = (Button) findViewById(R.id.ViewDriver);
        ViewDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAllActivity.this, ViewDriverActivity.class);
                startActivity(intent);
            }
        });
        ViewFaculty = (Button) findViewById(R.id.viewFaculty);
        ViewFaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAllActivity.this, ViewFacultyActivity.class);
                startActivity(intent);
            }
        });
        AddFaculty = (Button) findViewById(R.id.addFaculty);
        AddFaculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminAllActivity.this, AddFacultyActivity.class);
                startActivity(intent);
            }
        });
    }
}