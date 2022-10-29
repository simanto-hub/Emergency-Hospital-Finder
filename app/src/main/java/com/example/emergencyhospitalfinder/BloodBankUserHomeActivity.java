package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BloodBankUserHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView hospitalCardView1,hospitalCardView2,hospitalCardView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_user_home);
        hospitalCardView1 = findViewById(R.id.hospitalCardViewId1);
        hospitalCardView2 = findViewById(R.id.hospitalCardViewId2);
        hospitalCardView3 = findViewById(R.id.hospitalCardViewId3);

        hospitalCardView1.setOnClickListener(this);
        hospitalCardView2.setOnClickListener(this);
        hospitalCardView3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() ==R.id.hospitalCardViewId1)
        {
            Intent intent = new Intent(BloodBankUserHomeActivity.this,BloodBankUserActivity.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId2)
        {
            Intent intent = new Intent(BloodBankUserHomeActivity.this,BloodBankDistrictUserActivity.class);
            startActivity(intent);
        }
        else if (v.getId() ==R.id.hospitalCardViewId3)
        {
            Intent intent = new Intent(BloodBankUserHomeActivity.this,BloodBankThanaUserActivity.class);
            startActivity(intent);
        }
    }
}