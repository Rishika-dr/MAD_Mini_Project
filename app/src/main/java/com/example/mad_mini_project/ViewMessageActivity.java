package com.example.mad_mini_project;

import static com.example.mad_mini_project.Constants.TOPIC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class ViewMessageActivity extends AppCompatActivity {
    //defining database
    RecyclerView recyclerView;
    DatabaseReference database;
    Query limit;
    myAdapter3 myadapter3;
    ArrayList<msg> list3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        recyclerView=findViewById(R.id.viewb);
        //connecting to database
        database= FirebaseDatabase.getInstance().getReference("message");
        limit=database.limitToLast(5);
       // var rootref=firebase.database.ref().child("message")
       //not depend on the adapter content
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //to get the content in reverse order
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        list3=new ArrayList<>();
        myadapter3=new myAdapter3(this,list3);
        recyclerView.setAdapter(myadapter3);
        //to subscribe to topic
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        limit.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //to get data from the firebase
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    msg mg=dataSnapshot.getValue(msg.class);

                    list3.add(mg);



                }
                //notify dataset chage

                myadapter3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}