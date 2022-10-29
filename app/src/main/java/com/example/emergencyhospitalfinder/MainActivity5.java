package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity5 extends AppCompatActivity {
    RecyclerView recview;
    adminadapter adapter;
    FloatingActionButton fb;
    SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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

        FirebaseRecyclerOptions<adminadapterModel> options =
                new FirebaseRecyclerOptions.Builder<adminadapterModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospitals"), adminadapterModel.class)
                        .build();

        adapter=new adminadapter(options);
        recview.setAdapter(adapter);

        fb=(FloatingActionButton)findViewById(R.id.fadd);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      startActivity(new Intent(getApplicationContext(),adddata.class));
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


        FirebaseRecyclerOptions<adminadapterModel> options =
                new FirebaseRecyclerOptions.Builder<adminadapterModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospitals").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), adminadapterModel.class)
                        .build();

        adapter=new adminadapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }
}