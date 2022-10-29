package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HospitalDetailsUserActivity extends AppCompatActivity {
    TextView tv_1,tv_2,tv_3,tv_4,tv_5;
    DatabaseReference reference;
    String _NAME,  _PHONE, _ADDRESS, _SEAT, _ICUSEAT,_WEBSITE;
    Button call_btn,website_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details_user);

        call_btn=findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone =_PHONE;
                Log.d("TAG", "Working");
                String uri = "tel:"+phone.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

      website_btn=findViewById(R.id.website_btn);
      website_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String website = _WEBSITE;
              String uri = website.trim();
              Intent intent = new Intent(Intent.ACTION_VIEW);
              intent.setData(Uri.parse(uri));
              startActivity(intent);
          }
      });

        reference = FirebaseDatabase.getInstance().getReference("Hospitals");

        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);

        tv_4=findViewById(R.id.tv_4);
        tv_5=findViewById(R.id.tv_5);

        showAllData();
    }

    private void showAllData() {
        reference = FirebaseDatabase.getInstance().getReference("Hospitals");

        Intent intent = getIntent();



        _NAME=intent.getStringExtra("name");
        _PHONE=intent.getStringExtra("phone");
        _SEAT=intent.getStringExtra("seat");
        _ICUSEAT=intent.getStringExtra("icuSeat");
        _ADDRESS=intent.getStringExtra("address");
        _WEBSITE=intent.getStringExtra("website");

        tv_1.setText(_NAME);
        tv_2.setText(_ADDRESS);
        tv_4.setText(_SEAT);
        tv_5.setText(_ICUSEAT);

        Log.i("NAME",_NAME);
        Log.i("PHONE",_PHONE);
        Log.i("SEAT",_SEAT);
        Log.i("ICUSEAT",_ICUSEAT);
        Log.i("ADDRESS",_ADDRESS);
        Log.i("WEBSITE",_WEBSITE);

    }
}