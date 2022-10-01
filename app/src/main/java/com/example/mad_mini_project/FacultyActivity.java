package com.example.mad_mini_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FacultyActivity extends AppCompatActivity {
    //defining variable
    EditText facultyname;
    EditText facultyid;
    Button btn;
    ProgressDialog progressDialog;
    Button add;
    DatabaseReference faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        //intailizing variable
        facultyname = (EditText) findViewById(R.id.FacName);
        facultyid = (EditText) findViewById(R.id.FacID);
        btn = (Button) findViewById(R.id.Faculty);
        final SharedPreferences sharedPreferences=getSharedPreferences("faculty", Context.MODE_PRIVATE);//memory type to store data
        progressDialog = new ProgressDialog(this);
        final  String type=sharedPreferences.getString("name","");
        if(type.isEmpty())
        {
            //toast message
            Toast.makeText(getApplicationContext(),"Please Login",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //toast message
            Intent i=new Intent(FacultyActivity.this,FacultyHomeActivity.class);
            startActivity(i);
        }

        faculty = FirebaseDatabase.getInstance().getReference().child("Faculty");
        add = findViewById(R.id.Faculty);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                faculty.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot snapshot1 : snapshot.getChildren()){
                            String id=snapshot1.child("facultyID").getValue().toString();
                            if(id.contentEquals(facultyid.getText().toString()))
                            {
                                Intent intent=new Intent(FacultyActivity.this,FacultyHomeActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                SharedPreferences.Editor editor=sharedPreferences.edit();//store the value
                                editor.putString("name",facultyname.getText().toString());
                                editor.putString("pws",facultyid.getText().toString());
                                editor.commit();//store in memory
                                break;
                            }
                            else
                            {
                                Toast.makeText(FacultyActivity.this, "Not a Mite Faculty", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}