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

public class HospitalActivity7 extends AppCompatActivity {

    Button callBtn;
    Button websiteBtn;
    Firebase firebase7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital7);

        final TextView textView7 = (TextView)findViewById(R.id.hospitalSeat_7);
        Firebase.setAndroidContext(getApplicationContext());

        firebase7 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat7");
        firebase7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childText7 = dataSnapshot.getValue(String.class);
                textView7.setText(childText7);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                textView7.setText("Error found!");
            }
        });



        websiteBtn =findViewById(R.id.website_btn);
        callBtn =findViewById(R.id.call_btn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09666-700100"));
                startActivity(intent);
            }
        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://www.bdspecializedhospital.com/");
            }

            private void gotoUrl(String s) {
                Uri uri =Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

    }
    public void btnFindLocation(View view){

        startActivity(new Intent(this,MapsActivity8.class));
    }
    }
