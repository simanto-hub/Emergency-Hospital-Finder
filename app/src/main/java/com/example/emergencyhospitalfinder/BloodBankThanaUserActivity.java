package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BloodBankThanaUserActivity extends AppCompatActivity {
    RecyclerView recview;

   bloodbankThanaAdapter adapter;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_thana_user);

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
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Blood Bank"), amulancemodel.class)
                        .build();
        adapter=new bloodbankThanaAdapter(options);
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


        FirebaseRecyclerOptions<amulancemodel> options =
                new FirebaseRecyclerOptions.Builder<amulancemodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Blood Bank").orderByChild("thana").startAt(s).endAt(s + "\uf8ff"), amulancemodel.class)
                        .build();

        adapter=new bloodbankThanaAdapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);
    }
}