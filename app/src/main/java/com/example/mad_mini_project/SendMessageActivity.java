package com.example.mad_mini_project;

import static com.example.mad_mini_project.Constants.TOPIC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_mini_project.api.ApiUtilities;
import com.example.mad_mini_project.model.NotificationData;
import com.example.mad_mini_project.model.PushNotification;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMessageActivity extends AppCompatActivity {
    //Defining Variable
    EditText message;
    String title;
    String text;
    Button send;
    DatabaseReference send_message;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    SimpleDateFormat simpleTimeFormat;
    String Date;
    String Time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        //Initializing variable
        message = (EditText) findViewById(R.id.message);
        //retriving current date and time
        calendar=Calendar.getInstance();
        simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        simpleTimeFormat=new SimpleDateFormat("hh:mm a");
        Date=simpleDateFormat.format(calendar.getTime());
        Time=simpleTimeFormat.format(calendar.getTime());
        //connecting firebase
        send_message = FirebaseDatabase.getInstance().getReference().child("message");
        send = (Button) findViewById(R.id.btnMesaage);
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling insertbusdetaildata class
                insertbusdetaildata();
            }

            private void insertbusdetaildata() {
                //retrive message from admin and some defined messages
                String msg;
                msg = message.getText().toString();
                title="New Notification Arrived";
                text="Check the Latest Message";
                //Creating PushNotification object and passing NotificationData object as parameter where we will get title and text of notification
                if ( !msg.isEmpty()) {
                    PushNotification notification = new PushNotification(new NotificationData(title,text), TOPIC);
                    sendNotification(notification);
                }
                ////creating Message object with parameterized constructors
                Message m = new Message(Date,Time,msg);
                //toast message
                send_message.push().setValue(m);
            }
        });
    }
    private void sendNotification(PushNotification notification) {
        ApiUtilities.getClient().sendNotification(notification).enqueue(new Callback<PushNotification>() {
            @Override
            public void onResponse(Call<PushNotification> call, Response<PushNotification> response) {
                if(response.isSuccessful())
                    Toast.makeText(SendMessageActivity.this,"Sent",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SendMessageActivity.this,"Not Sent",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PushNotification> call, Throwable t) {
                Toast.makeText(SendMessageActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
