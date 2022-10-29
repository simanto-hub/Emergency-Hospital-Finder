package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AmbulanceRequestPendingActivity extends AppCompatActivity {
    RecyclerView recview;
    ambulancependingadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_request_pending);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<bloodbankModel> options =
                new FirebaseRecyclerOptions.Builder<bloodbankModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ambulance Services Pending"),bloodbankModel.class)
                        .build();

        adapter=new ambulancependingadapter(options);
        recview.setAdapter(adapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}