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

public class HospitalActivity12 extends AppCompatActivity {

    Button callBtn;
    Button websiteBtn;
    Firebase firebase12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital12);

        final TextView textView12 = (TextView)findViewById(R.id.hospitalSeat_12);
        Firebase.setAndroidContext(getApplicationContext());

        firebase12 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat12");
        firebase12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childText12 = dataSnapshot.getValue(String.class);
                textView12.setText(childText12);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                textView12.setText("Error found!");
            }
        });

        websiteBtn =findViewById(R.id.website_btn);
        callBtn =findViewById(R.id.call_btn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-44891001"));
                startActivity(intent);
            }
        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://aichihospital.com/");
            }

            private void gotoUrl(String s) {
                Uri uri =Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });


    }
    public void btnFindLocation(View view){

        startActivity(new Intent(this,MapsActivity13.class));
    }
    }
