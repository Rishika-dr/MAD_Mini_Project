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
        textno = (EditText) findViewById(R.id.BusNo);
        textdriver = (EditText) findViewById(R.id.DriverName);
        textroute = (EditText) findViewById(R.id.dest);
        textphone = (EditText) findViewById(R.id.DriverPhone);
        bus_details = FirebaseDatabase.getInstance().getReference().child("drivers");
        add_button = findViewById(R.id.btnAddDriver);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertbusdetaildata();
            }

            private void insertbusdetaildata() {
                String drv_busno = textno.getText().toString();
                String drv_name = textdriver.getText().toString();
                String route = textroute.getText().toString();
                String drv_phone = textphone.getText().toString();
                BusDetails busdetails = new BusDetails(drv_busno, drv_name, route, drv_phone);
                bus_details.push().setValue(busdetails);
                Toast.makeText(AddDriverActivity.this, "Bus Detail Added", Toast.LENGTH_SHORT).show();


            }
        });
    }
}