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

public class HospitalActivity15 extends AppCompatActivity {
    Button callBtn;
    Button websiteBtn;
    Button findLocationBtnId;
    Firebase firebase15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital15);

        final TextView textView15 = (TextView)findViewById(R.id.hospitalSeat_15);
        Firebase.setAndroidContext(getApplicationContext());

        firebase15 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat15");
        firebase15.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childText15 = dataSnapshot.getValue(String.class);
                textView15.setText(childText15);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                textView15.setText("Error found!");
            }
        });


        websiteBtn =findViewById(R.id.website_btn);
        callBtn =findViewById(R.id.call_btn);

        findLocationBtnId =findViewById(R.id.findLocationBtnId);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01914-001313"));
                startActivity(intent);
            }
        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://www.uhlbd.com/");
            }

            private void gotoUrl(String s) {
                Uri uri =Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });





    }
    public void btnFindLocation(View view){

        startActivity(new Intent(this,MapsActivity16.class));
    }
    }
