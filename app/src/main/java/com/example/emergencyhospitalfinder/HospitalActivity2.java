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

public class HospitalActivity2 extends AppCompatActivity {

    Button callBtn;
    Button websiteBtn;
    Firebase firebase2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital2);

        final TextView textView2 = (TextView)findViewById(R.id.hospitalSeat_2);
        Firebase.setAndroidContext(getApplicationContext());

        firebase2 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat2");
        firebase2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childText2 = dataSnapshot.getValue(String.class);
                textView2.setText(childText2);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                textView2.setText("Error found!");
            }
        });



        websiteBtn =findViewById(R.id.website_btn);
        callBtn =findViewById(R.id.call_btn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-9661551"));
                startActivity(intent);
            }
        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://birdembd.org/");
            }

            private void gotoUrl(String s) {
                Uri uri =Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });



    }
    public void btnFindLocation(View view){

        startActivity(new Intent(this,MapsActivity3.class));
    }
}