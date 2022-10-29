package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BloodBankSuperAdminActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_super_admin);
    }

    @Override
    public void onClick (View v){
        if (v.getId() == R.id.requestBtn) {
            Intent intent = new Intent(BloodBankSuperAdminActivity.this,BloodBankRequestPendingActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.editBtn) {
            Intent intent = new Intent(BloodBankSuperAdminActivity.this, AdminBloodBankActivity.class);
            startActivity(intent);
        }
    }
}