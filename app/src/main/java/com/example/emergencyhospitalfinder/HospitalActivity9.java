package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class HospitalActivity9 extends AppCompatActivity {
    Button callBtn;
    Button websiteBtn;
    Firebase firebase9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital9);

        final TextView textView9 = (TextView)findViewById(R.id.hospitalSeat_9);
        Firebase.setAndroidContext(getApplicationContext());

        firebase9 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat9");
        firebase9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childText9 = dataSnapshot.getValue(String.class);
                textView9.setText(childText9);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                textView9.setText("Error found!");
            }
        });

        websiteBtn =findViewById(R.id.website_btn);
        callBtn =findViewById(R.id.call_btn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01992-346631"));
                startActivity(intent);
            }
        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.ibfbd.org/institute/hospitals/islami-bank-hospital-mirpur-dhaka");
            }

            private void gotoUrl(String s) {
                Uri uri =Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

    }
    public void btnFindLocation(View view){

        startActivity(new Intent(this,MapsActivity10.class));
    }
    }
