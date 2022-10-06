package com.example.mad_mini_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class StudentRegisterActivity extends AppCompatActivity {
    //defining varaible
    TextView AlreadyHaveAccount;
    EditText StudentName,USN,StudentEmail,StudentPhone,StudentPassword;
    Button btnStudentRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String pattern="4MT19[A-Z][A-Z][0-9][0-9][0-9]";
    String pattern1="4MT20[A-Z][A-Z][0-9][0-9][0-9]";
    String pattern2="4MT21[A-Z][A-Z][0-9][0-9][0-9]";
    String pattern3="4MT22[A-Z][A-Z][0-9][0-9][0-9]";

    DatabaseReference students_details;
    ProgressDialog progressDialog;
    String userID;

    FirebaseAuth fAuth;
    FirebaseUser fUser;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AlreadyHaveAccount=findViewById(R.id.AlreadyHaveAccount);
        //initailizing varaible
        StudentName=findViewById(R.id.StudentName);
        USN=findViewById(R.id.USN);
        StudentEmail=findViewById(R.id.StudentEmail);
        StudentPhone=findViewById(R.id.StudentPhone);
        StudentPassword=findViewById(R.id.StudentPassword);
        btnStudentRegister=findViewById(R.id.btnStudentRegister);
        progressDialog=new ProgressDialog(this);
        fAuth=FirebaseAuth.getInstance();
        fUser=fAuth.getCurrentUser();
//        fStore=FirebaseFirestore.getInstance();
        AlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentRegisterActivity.this,StudentLoginActivity.class));
            }
        });

        btnStudentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();
            }
        });
    }

    private void PerforAuth() {
        String std_name=StudentName.getText().toString();
        String std_usn=USN.getText().toString();
        String std_email=StudentEmail.getText().toString();
        String std_phone=StudentPhone.getText().toString();
        String std_password=StudentPassword.getText().toString();
        //to check whether Email validation is correct or not and
        if(!std_email.matches(emailPattern))
        {
            StudentEmail.setError("Enter Correct Email");
        }
        // to check USN pattern matches
        else if(!std_usn.matches(pattern))
        {
            if(!std_usn.matches(pattern1))
            {
                if(!std_usn.matches(pattern2))
                {
                    if(!std_usn.matches(pattern3))
                    {
                        USN.setError("Enter Correct Email");
                    }
                }
            }
        }
        //to check password is strong
        else if (std_password.isEmpty() || std_password.length()<6)
        {
            StudentPassword.setError("Password is not strong");
        }
        //to check length of phone number is equal to  10
        else if (std_phone.length()<10)
        {
            StudentPhone.setError("Enter Correct Phone Number");
        }
        else
        {
            //progress dialog message
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            fAuth.createUserWithEmailAndPassword(std_email,std_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(StudentRegisterActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(StudentRegisterActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(StudentRegisterActivity.this,StudentLoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}