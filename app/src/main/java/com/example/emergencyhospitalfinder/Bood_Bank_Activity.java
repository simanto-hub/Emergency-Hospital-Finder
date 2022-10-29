package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Bood_Bank_Activity extends AppCompatActivity {
    ImageView bloodCall_1,bloodCall_2,bloodCall_3,bloodCall_4,bloodCall_5,bloodCall_6,
            bloodCall_7,bloodCall_8,bloodCall_9,bloodCall_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bood__bank_);

        bloodCall_1= findViewById(R.id.blood_call_1);
        bloodCall_2= findViewById(R.id.blood_call_2);
        bloodCall_3= findViewById(R.id.blood_call_3);
        bloodCall_4= findViewById(R.id.blood_call_4);
        bloodCall_5= findViewById(R.id.blood_call_5);
        bloodCall_6= findViewById(R.id.blood_call_6);
        bloodCall_7= findViewById(R.id.blood_call_7);
        bloodCall_8= findViewById(R.id.blood_call_8);
        bloodCall_9= findViewById(R.id.blood_call_9);
        bloodCall_10= findViewById(R.id.blood_call_10);

        bloodCall_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-9139940"));
                startActivity(intent);
            }
        });

        bloodCall_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-8624249"));
                startActivity(intent);
            }
        });

        bloodCall_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01850-077185"));
                startActivity(intent);
            }
        });

        bloodCall_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01772-829082"));
                startActivity(intent);
            }
        });

        bloodCall_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-9668690"));
                startActivity(intent);
            }
        });

        bloodCall_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-9351969"));
                startActivity(intent);
            }
        });

        bloodCall_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01678-313428"));
                startActivity(intent);
            }
        });

        bloodCall_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01988-877800"));
                startActivity(intent);
            }
        });

        bloodCall_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02-9362573"));
                startActivity(intent);
            }
        });

        bloodCall_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01713-488418"));
                startActivity(intent);
            }
        });

    }
}