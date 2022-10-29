package com.example.emergencyhospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AllHospitalActivity extends AppCompatActivity implements View.OnClickListener{

     private CardView hospitalCardView1,hospitalCardView2,hospitalCardView3,hospitalCardView4,
             hospitalCardView5,hospitalCardView6,hospitalCardView7,hospitalCardView8,
             hospitalCardView9,hospitalCardView10,hospitalCardView11,hospitalCardView12,
             hospitalCardView13,hospitalCardView14,hospitalCardView15;


       Firebase firebase,firebase2,firebase3,firebase4,firebase5,firebase6,firebase7,firebase8,firebase9,firebase10,firebase11,
               firebase12,firebase13,firebase14,firebase15;



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hospital);

         final TextView textView1 = (TextView)findViewById(R.id.hospitalSeat1);
         final TextView textView2 = (TextView)findViewById(R.id.hospitalSeat2);
         final TextView textView3 = (TextView)findViewById(R.id.hospitalSeat3);
         final TextView textView4 = (TextView)findViewById(R.id.hospitalSeat4);
         final TextView textView5 = (TextView)findViewById(R.id.hospitalSeat5);
         final TextView textView6 = (TextView)findViewById(R.id.hospitalSeat6);
         final TextView textView7 = (TextView)findViewById(R.id.hospitalSeat7);
         final TextView textView8 = (TextView)findViewById(R.id.hospitalSeat8);
         final TextView textView9 = (TextView)findViewById(R.id.hospitalSeat9);
         final TextView textView10 = (TextView)findViewById(R.id.hospitalSeat10);
         final TextView textView11 = (TextView)findViewById(R.id.hospitalSeat11);
         final TextView textView12 = (TextView)findViewById(R.id.hospitalSeat12);
         final TextView textView13 = (TextView)findViewById(R.id.hospitalSeat13);
         final TextView textView14 = (TextView)findViewById(R.id.hospitalSeat14);
         final TextView textView15 = (TextView)findViewById(R.id.hospitalSeat15);

         Firebase.setAndroidContext(getApplicationContext());


         firebase = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat");
         firebase.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText = dataSnapshot.getValue(String.class);
                 textView1.setText(childText);

             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView1.setText("Error found!");

             }
         });

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

         firebase3 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat3");
         firebase3.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText3 = dataSnapshot.getValue(String.class);
                 textView3.setText(childText3);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView3.setText("Error found!");
             }
         });

         firebase4 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat4");
         firebase4.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText4 = dataSnapshot.getValue(String.class);
                 textView4.setText(childText4);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView4.setText("Error found!");
             }
         });

         firebase5 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat5");
         firebase5.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText5 = dataSnapshot.getValue(String.class);
                 textView5.setText(childText5);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView5.setText("Error found!");
             }
         });

         firebase6 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat6");
         firebase6.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText6 = dataSnapshot.getValue(String.class);
                 textView6.setText(childText6);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView6.setText("Error found!");
             }
         });

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

         firebase8 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat8");
         firebase8.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText8 = dataSnapshot.getValue(String.class);
                 textView8.setText(childText8);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView8.setText("Error found!");
             }
         });

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

         firebase10 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat10");
         firebase10.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText10 = dataSnapshot.getValue(String.class);
                 textView10.setText(childText10);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView10.setText("Error found!");
             }
         });

         firebase11 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat11");
         firebase11.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText11 = dataSnapshot.getValue(String.class);
                 textView11.setText(childText11);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView11.setText("Error found!");
             }
         });

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

         firebase13 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat13");
         firebase13.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText13 = dataSnapshot.getValue(String.class);
                 textView13.setText(childText13);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView13.setText("Error found!");
             }
         });

         firebase14 = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat14");
         firebase14.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String childText14 = dataSnapshot.getValue(String.class);
                 textView14.setText(childText14);
             }

             @Override
             public void onCancelled(FirebaseError firebaseError) {
                 textView14.setText("Error found!");
             }
         });

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




         hospitalCardView1 = findViewById(R.id.hospitalCardViewId1);
        hospitalCardView2 = findViewById(R.id.hospitalCardViewId2);
        hospitalCardView3 = findViewById(R.id.hospitalCardViewId3);
        hospitalCardView4 = findViewById(R.id.hospitalCardViewId4);
        hospitalCardView5 = findViewById(R.id.hospitalCardViewId5);
        hospitalCardView6 = findViewById(R.id.hospitalCardViewId6);
        hospitalCardView7 = findViewById(R.id.hospitalCardViewId7);
        hospitalCardView8 = findViewById(R.id.hospitalCardViewId8);
        hospitalCardView9 = findViewById(R.id.hospitalCardViewId9);
        hospitalCardView10 = findViewById(R.id.hospitalCardViewId10);
        hospitalCardView11 = findViewById(R.id.hospitalCardViewId11);
        hospitalCardView12 = findViewById(R.id.hospitalCardViewId12);
        hospitalCardView13 = findViewById(R.id.hospitalCardViewId13);
        hospitalCardView14 = findViewById(R.id.hospitalCardViewId14);
        hospitalCardView15 = findViewById(R.id.hospitalCardViewId15);


        hospitalCardView1.setOnClickListener(this);
        hospitalCardView2.setOnClickListener(this);
        hospitalCardView3.setOnClickListener(this);
        hospitalCardView4.setOnClickListener(this);
        hospitalCardView5.setOnClickListener(this);
        hospitalCardView6.setOnClickListener(this);
        hospitalCardView7.setOnClickListener(this);
        hospitalCardView8.setOnClickListener(this);
        hospitalCardView9.setOnClickListener(this);
        hospitalCardView10.setOnClickListener(this);
        hospitalCardView11.setOnClickListener(this);
        hospitalCardView12.setOnClickListener(this);
        hospitalCardView13.setOnClickListener(this);
        hospitalCardView14.setOnClickListener(this);
        hospitalCardView15.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {

        if (v.getId() ==R.id.hospitalCardViewId1)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity1.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId2)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity2.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId3)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity3.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId4)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity4.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId5)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity5.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId6)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity6.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId7)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity7.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId8)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity8.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId9)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity9.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId10)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity10.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId11)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity11.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId12)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity12.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId13)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity13.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId14)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity14.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId15)
        {
            Intent intent = new Intent(AllHospitalActivity.this,HospitalActivity15.class);
            startActivity(intent);
        }
    }




}