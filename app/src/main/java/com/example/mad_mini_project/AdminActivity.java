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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminActivity extends AppCompatActivity {
    //Defining Variable
    EditText lname, lpws;
    Button lbtn;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //Initializing Variable
        lname = findViewById(R.id.AdminUsername);
        lpws=findViewById(R.id.AdminPassword);
        lbtn = findViewById(R.id.btnAdminLogin);
        //code for Auto login
        final SharedPreferences sharedPreferences=getSharedPreferences("Data", Context.MODE_PRIVATE);//memory type to store data
        progressDialog = new ProgressDialog(this);
        final  String type=sharedPreferences.getString("name","");
        if(type.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Login",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i=new Intent(AdminActivity.this,AdminAllActivity.class);
            startActivity(i);
        }
        //onclick activity
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code for auto login
                SharedPreferences.Editor editor=sharedPreferences.edit();//store the value
                editor.putString("name",lname.getText().toString());
                editor.putString("pws",lpws.getText().toString());
                editor.commit();//store in memory
                //retieving user entered data
                String un=lname.getText().toString();
                String pa=lpws.getText().toString();
                //authentication for admin and redirecting to AdminAllActivity page
                if(!un.equals("admin") ) {
                    Toast.makeText(AdminActivity.this,"Wrong Username!",Toast.LENGTH_LONG).show();
                    return;
                }else if(!pa.equals("admin")){
                    Toast.makeText(AdminActivity.this,"Wrong password!",Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    Toast.makeText(AdminActivity.this,"Welcome Admin!",Toast.LENGTH_LONG).show();

                    Intent i=new Intent(AdminActivity.this,AdminAllActivity.class);
                    startActivity(i);
                }

            }
        });
    }
}