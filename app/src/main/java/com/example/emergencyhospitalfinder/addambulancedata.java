package com.example.emergencyhospitalfinder;

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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addambulancedata extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    Button saveBtn,backBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addambulancedata);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5 = (EditText) findViewById(R.id.t5);


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
        t3.addTextChangedListener(new TextWatcher() {
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
        t4.addTextChangedListener(new TextWatcher() {
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
        t5.addTextChangedListener(new TextWatcher() {
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

        backBtn=(Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AdminAmbulanceActivity.class));
                finish();
            }
        });
        saveBtn=(Button)findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Ambulance Services");


                String name =t1.getText().toString().trim();
                String address =t2.getText().toString().trim();
                String phone =t3.getText().toString().trim();
                String district =t4.getText().toString().trim();
                String thana =t5.getText().toString().trim();




                amulancemodel bloodbankAddModel = new amulancemodel(name,address,phone,district,thana);
                reference.child(phone).setValue(bloodbankAddModel);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");



                Toast.makeText(getApplicationContext(),"Value Inserted",Toast.LENGTH_LONG).show();


            }
        });
    }


    private Boolean validateName(){
        String val = t1.getText().toString();

        if (val.isEmpty()){
            t1.setError("Field cannot be empty");
            return false;
        }
        else {
            t1.setError(null);

            return true;
        }
    }
    private Boolean validateAddress(){
        String val = t2.getText().toString();

        if (val.isEmpty()){
            t2.setError("Field cannot be empty");
            return false;
        }
        else {
            t2.setError(null);
            return true;
        }
    }
    private Boolean validatePhone(){
        String val = t3.getText().toString();

        if (val.isEmpty()){
            t3.setError("Field cannot be empty");
            return false;
        }
        else {
            t3.setError(null);
            return true;
        }
    }
    private Boolean validateDistrict(){
        String val = t4.getText().toString();

        if (val.isEmpty()){
            t4.setError("Field cannot be empty");
            return false;
        }
        else {
            t4.setError(null);
            return true;
        }
    }
    private Boolean validateThana(){
        String val = t5.getText().toString();

        if (val.isEmpty()){
            t5.setError("Field cannot be empty");
            return false;
        }
        else {
            t5.setError(null);
            return true;
        }
    }

    public  void registerUser(View view){

        if ( !validateName()  | !validateAddress() |  !validatePhone()  | !validateDistrict() | !validateThana()){
            return;
        }



        String name =t1.getText().toString();
        String address =t2.getText().toString();
        String phone =t3.getText().toString();
        String district =t4.getText().toString();
        String thana =t5.getText().toString();


        amulancemodel bloodbankAddModel = new amulancemodel(name,address,phone,district,thana);
        reference.child(phone).setValue(bloodbankAddModel);
    }

    private void checkInputs () {
        if (!TextUtils.isEmpty(t1.getText())) {
            if (!TextUtils.isEmpty(t2.getText())) {
                if (!TextUtils.isEmpty(t3.getText())) {
                    if (!TextUtils.isEmpty(t4.getText())) {
                        if (!TextUtils.isEmpty(t5.getText())){
                            saveBtn.setEnabled(true);
                            saveBtn.setTextColor(Color.rgb(255, 255, 255));
                        }else{
                            saveBtn.setEnabled(false);
                            saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
                        }

                    } else {
                        saveBtn.setEnabled(false);
                        saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
                    }
                } else {
                    saveBtn.setEnabled(false);
                    saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
                }
            } else {
                saveBtn.setEnabled(false);
                saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
            }
        } else {
            saveBtn.setEnabled(false);
            saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
        }


    }

}