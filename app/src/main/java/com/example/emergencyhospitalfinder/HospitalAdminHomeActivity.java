package com.example.emergencyhospitalfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HospitalAdminHomeActivity extends AppCompatActivity {
    TextView tv_1,tv_2;
    EditText t1,t2,t3,t4,t5,t6,t7,t8;

    DatabaseReference reference;
    String _NAME, _USERNAME, _PHONE, _ADDRESS, _SEAT, _ICUSEAT,_PASSWORD,_DISTRICT,_THANA,_WEBSITE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_admin_home);

        reference = FirebaseDatabase.getInstance().getReference("Hospitals");

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);

        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);

        showAllData();


    }

    private void showAllData() {

        Intent intent = getIntent();
        _USERNAME=intent.getStringExtra("username");
        _NAME=intent.getStringExtra("name");
        _PHONE=intent.getStringExtra("phone");
        _SEAT=intent.getStringExtra("seat");
        _ICUSEAT=intent.getStringExtra("icuSeat");
        _ADDRESS=intent.getStringExtra("address");
        _DISTRICT=intent.getStringExtra("district");
        _THANA=intent.getStringExtra("thana");
        _WEBSITE=intent.getStringExtra("website");

        tv_1.setText(_NAME);
        tv_2.setText(_USERNAME);
        t1.setText(_NAME);
        t2.setText(_ADDRESS);
        t3.setText(_PHONE);
        t4.setText(_SEAT);
        t5.setText(_ICUSEAT);
        t6.setText(_DISTRICT);
        t7.setText(_THANA);
        t8.setText(_WEBSITE);
    }
    public void update(View view){

        if (isNameChanged() ||  isAddressChanged() || isPhoneNumberChanged() || isSeatChanged() || isICUSeatChanged() || isDistrictChanged() || isThanaChanged() || isWebsiteChanged()){
            Toast.makeText(this,"Data has been updated",Toast.LENGTH_LONG).show();

        }
        else Toast.makeText(this,"Data is same and cannot be updated",Toast.LENGTH_LONG).show();
    }

    private boolean isAddressChanged() {
        if (!_ADDRESS.equals(t2.getText().toString())){
            reference.child(_PHONE).child("address").setValue(t2.getText().toString());
            _ADDRESS = t2.getText().toString();
            return true;
        }else {
           return false;
        }
    }

    private boolean isNameChanged() {

        if (!_NAME.equals(t1.getText().toString())){
            reference.child(_PHONE).child("name").setValue(t1.getText().toString());
            _NAME = t1.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isPhoneNumberChanged() {

        if (!_PHONE.equals(t3.getText().toString())){
            reference.child(_PHONE).child("phone").setValue(t3.getText().toString());
            _PHONE = t3.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isSeatChanged() {

        if (!_SEAT.equals(t4.getText().toString())){
            reference.child(_PHONE).child("seat").setValue(t4.getText().toString());
            _SEAT = t4.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isICUSeatChanged() {

        if (!_ICUSEAT.equals(t5.getText().toString())){
            reference.child(_PHONE).child("icuSeat").setValue(t5.getText().toString());
            _ICUSEAT = t5.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isDistrictChanged() {

        if (!_DISTRICT.equals(t6.getText().toString())){
            reference.child(_PHONE).child("district").setValue(t6.getText().toString());
            _DISTRICT = t6.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isThanaChanged() {

        if (!_THANA.equals(t7.getText().toString())){
            reference.child(_PHONE).child("thana").setValue(t7.getText().toString());
            _THANA = t7.getText().toString();
            return true;
        }else {
            return false;
        }
    }

    private boolean isWebsiteChanged() {

        if (!_WEBSITE.equals(t8.getText().toString())){
            reference.child(_PHONE).child("website").setValue(t8.getText().toString());
            _WEBSITE = t8.getText().toString();
            return true;
        }else {
            return false;
        }
    }
}