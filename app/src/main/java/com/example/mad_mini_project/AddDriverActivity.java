package com.example.mad_mini_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDriverActivity extends AppCompatActivity {
    //Defining Variable
    EditText textno;
    EditText textdriver;
    EditText textroute;
    EditText textphone;
    Button add_button;
    DatabaseReference bus_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        //Initializing Variable
        textno = (EditText) findViewById(R.id.BusNo);
        textdriver = (EditText) findViewById(R.id.DriverName);
        textroute = (EditText) findViewById(R.id.dest);
        textphone = (EditText) findViewById(R.id.DriverPhone);
        //Connecting firebase
        bus_details = FirebaseDatabase.getInstance().getReference().child("drivers");
        add_button = findViewById(R.id.btnAddDriver);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling insertbusdetaildata class
                insertbusdetaildata();
            }
            private void insertbusdetaildata() {
                //retrieving admin entered data
                String drv_busno = textno.getText().toString();
                String drv_name = textdriver.getText().toString();
                String route = textroute.getText().toString();
                String drv_phone = textphone.getText().toString();
                //creating BusDetails object with parameterized constructors
                BusDetails busdetails = new BusDetails(drv_busno, drv_name, route, drv_phone);
                //pushing data to firebase
                bus_details.push().setValue(busdetails);
                //toast message
                Toast.makeText(AddDriverActivity.this, "Bus Detail Added", Toast.LENGTH_SHORT).show();


            }
        });
    }
}