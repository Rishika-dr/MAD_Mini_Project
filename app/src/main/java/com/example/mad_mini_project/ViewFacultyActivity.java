package com.example.mad_mini_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewFacultyActivity extends AppCompatActivity {
    //defining database
    RecyclerView recyclerView;
    DatabaseReference database;
    myAdapter2 myadapter2;
    ArrayList<fac> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty);
        recyclerView=findViewById(R.id.viewfac);
        //connecting to database
        database= FirebaseDatabase.getInstance().getReference("Faculty");
//not depend on the adapter content
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list2=new ArrayList<>();
        myadapter2=new myAdapter2(this,list2);
        recyclerView.setAdapter(myadapter2);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    //to get data from firebase
                    fac f=dataSnapshot.getValue(fac.class);
                    list2.add(f);
                }
                //notify dataset change
                myadapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}