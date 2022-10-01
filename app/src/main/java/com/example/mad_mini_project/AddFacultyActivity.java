package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFacultyActivity extends AppCompatActivity {
    //Initializing Variable
    EditText facultyname;
    EditText facultyid;
    Button add;
    DatabaseReference faculty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initializing Variable
        setContentView(R.layout.activity_add_faculty);
        facultyname = (EditText) findViewById(R.id.FacName);
        facultyid = (EditText) findViewById(R.id.FacID);
        //Connecting firebase
        faculty = FirebaseDatabase.getInstance().getReference().child("Faculty");
        add = findViewById(R.id.Faculty);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling insertFacultydetaildata class
                insertFacultydetaildata();
            }

            private void insertFacultydetaildata() {
                //retrieving admin entered data
                String fac_name = facultyname.getText().toString();
                String fac_id = facultyid.getText().toString();
                //creating Faculty object with parameterized constructors
                Faculty fac = new Faculty(fac_name, fac_id);
                //pushing data to firebase
                faculty.push().setValue(fac);
                //toast message
                Toast.makeText(AddFacultyActivity.this, "Faculty Detail Added", Toast.LENGTH_SHORT).show();


            }
        });
    }
}