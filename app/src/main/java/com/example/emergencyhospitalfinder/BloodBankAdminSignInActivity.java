package com.example.emergencyhospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class BloodBankAdminSignInActivity extends AppCompatActivity {
    TextView notRegistered;
    EditText t1,t2;
    Button sign_in_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank_admin_sign_in);

        sign_in_btn=findViewById(R.id.sign_in_btn);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);

        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        t2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        notRegistered =findViewById(R.id.tv_not_registered);
        notRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodBankAdminSignInActivity.this,BloodBankAdminRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(t1.getText()) && validatePhone()){
            if(!TextUtils.isEmpty(t2.getText()) && validatePassword()){
                sign_in_btn.setEnabled(true);
                sign_in_btn.setTextColor(Color.rgb(255,255,255));
            }else{
                sign_in_btn.setEnabled(false);
                sign_in_btn.setTextColor(Color.argb(50,255,255,255));
            }

        }else{
            sign_in_btn.setEnabled(false);
            sign_in_btn.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private Boolean validatePhone(){
        String val = t1.getText().toString();


        if (val.isEmpty()){
            t1.setError("Field cannot be empty");
            return false;
        }else {
            t1.setError(null);

            return  true;
        }
    }
    private Boolean validatePassword(){
        String val = t2.getText().toString();


        if (val.isEmpty()){
            t2.setError("Field cannot be empty");
            return false;
        }else {
            t2.setError(null);

            return  true;
        }
    }

    public void logInUser(View view){
        if (!validatePhone() | !validatePassword()){
            return;
        }

        final String userPhone = t1.getText().toString().trim();
        final String userpassword = t2.getText().toString().trim();





        // DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Hospitals");
        //reference.orderByChild("phone").equalTo(completePhoneNumber);

        Query checkUser = FirebaseDatabase.getInstance().getReference("Blood Bank").orderByChild("phone").equalTo(userPhone);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    t1.setError(null);

                    String passwordFromDb= snapshot.child(userPhone).child("password").getValue(String.class);
                    if (passwordFromDb.equals(userpassword)){

                        t1.setError(null);


                        String nameFromDb= snapshot.child(userPhone).child("name").getValue(String.class);
                        String usernameFromDb= snapshot.child(userPhone).child("username").getValue(String.class);
                        String phoneFromDb= snapshot.child(userPhone).child("phone").getValue(String.class);
                        String seatFromDb= snapshot.child(userPhone).child("seat").getValue(String.class);
                        String icuSeatFromDb= snapshot.child(userPhone).child("icuSeat").getValue(String.class);
                        String addressFromDb= snapshot.child(userPhone).child("address").getValue(String.class);
                        String districtFromDb=snapshot.child(userPhone).child("district").getValue(String.class);
                        String thanaFromDb=snapshot.child(userPhone).child("thana").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),BloodBankAdminHomeActivity.class);
                        intent.putExtra("name",nameFromDb);
                        intent.putExtra("username",usernameFromDb);
                        intent.putExtra("password",passwordFromDb);
                        intent.putExtra("phone",phoneFromDb);
                        intent.putExtra("seat",seatFromDb);
                        intent.putExtra("icuSeat",icuSeatFromDb);
                        intent.putExtra("address",addressFromDb);
                        intent.putExtra("district",districtFromDb);
                        intent.putExtra("thana",thanaFromDb);

                        startActivity(intent);
                    }
                    else {
                        t2.setError("Wrong Password");
                        t2.requestFocus();
                    }
                }
                else {
                    t1.setError("No such Number exist");
                    t1.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BloodBankAdminSignInActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}