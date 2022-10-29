package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class AdminAmbulanceActivity extends AppCompatActivity {

    RecyclerView recview;
    ambulanceadapter adapter;
    FloatingActionButton fb;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ambulance);


        search = (SearchView) findViewById(R.id.search);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<amulancemodel> options =
                new FirebaseRecyclerOptions.Builder<amulancemodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ambulance Services"), amulancemodel.class)
                        .build();

        adapter=new ambulanceadapter(options);
        recview.setAdapter(adapter);

        fb=(FloatingActionButton)findViewById(R.id.fadd);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(),addambulancedata.class));
            }
        });
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


    private void processsearch(String  s) {


        FirebaseRecyclerOptions<amulancemodel> options =
                new FirebaseRecyclerOptions.Builder<amulancemodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ambulance Services").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), amulancemodel.class)
                        .build();

        adapter=new ambulanceadapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);


    }
}