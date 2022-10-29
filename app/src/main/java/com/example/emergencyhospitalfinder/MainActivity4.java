package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity  {
    RecyclerView recview;
    myadapter adapter;
    Button call_btn;
    SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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

          call_btn = (Button)findViewById(R.id.call_btn);
        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<addModel> options =
                new FirebaseRecyclerOptions.Builder<addModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospitals"), addModel.class)
                        .build();

        adapter=new  myadapter(options);

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



    private void processsearch(String  s) {


        FirebaseRecyclerOptions<addModel> options =
                new FirebaseRecyclerOptions.Builder<addModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospitals").orderByChild("name").startAt(s).endAt(s+"\uf8ff"),addModel.class)
                        .build();


        adapter=new myadapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);


    }
}