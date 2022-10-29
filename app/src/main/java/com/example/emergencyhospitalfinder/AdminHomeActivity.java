package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomeActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView allHospitalCardView,nearestPharmacyCardView, findAmbulanceCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        allHospitalCardView = findViewById(R.id.allHospitalCardViewId);
        nearestPharmacyCardView = findViewById(R.id.nearestPharmacyCardViewId);
        findAmbulanceCardView = findViewById(R.id.findAmbulanceCardViewId);

        allHospitalCardView.setOnClickListener(this);
        nearestPharmacyCardView.setOnClickListener(this);
        findAmbulanceCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.allHospitalCardViewId)
        {
            Intent intent = new Intent(AdminHomeActivity.this,SuperAdminActivity.class);
            startActivity(intent);
        }

        else if(v.getId() ==R.id.nearestPharmacyCardViewId)
        {
            Intent intent = new Intent(AdminHomeActivity.this,BloodBankSuperAdminActivity.class);
            startActivity(intent);
        }
        else if(v.getId() ==R.id.findAmbulanceCardViewId)
        {
            Intent intent = new Intent(AdminHomeActivity.this,AmbulanceSuperAdminActivity.class);
            startActivity(intent);
        }


    }
}