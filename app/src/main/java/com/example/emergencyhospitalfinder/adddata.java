package com.example.emergencyhospitalfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class adddata extends AppCompatActivity {

    EditText t1, t2, t3, t4, t5,t6,t7,t8;
    Button saveBtn, backBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);



        t1 = (EditText) findViewById(R.id.t1);
        t2 = (EditText) findViewById(R.id.t2);
        t3 = (EditText) findViewById(R.id.t3);
        t4 = (EditText) findViewById(R.id.t4);
        t5 = (EditText) findViewById(R.id.t5);
        t6 = (EditText) findViewById(R.id.t6);
        t7 = (EditText) findViewById(R.id.t7);
        t8 = (EditText) findViewById(R.id.t8);

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
        t6.addTextChangedListener(new TextWatcher() {
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
        t7.addTextChangedListener(new TextWatcher() {
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
        t8.addTextChangedListener(new TextWatcher() {
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


        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity5.class));
                finish();
            }
        });
        saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Hospitals");


                String name =t1.getText().toString().trim();
                String address =t2.getText().toString().trim();
                String seat =t3.getText().toString().trim();
                String phone =t4.getText().toString().trim();
                String icuSeat =t5.getText().toString().trim();
                String district =t6.getText().toString().trim();
                String thana =t7.getText().toString().trim();
                String website =t8.getText().toString().trim();



                addModel hospitalAddModel = new addModel(name,phone,seat,icuSeat,address,district,thana,website);
                reference.child(phone).setValue(hospitalAddModel);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");


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
    private Boolean validateSeat(){
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
    private Boolean validateICUSeat(){
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
    private Boolean validatePhone(){
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
    private Boolean validateDistrict(){
        String val = t6.getText().toString();

        if (val.isEmpty()){
            t6.setError("Field cannot be empty");
            return false;
        }
        else {
            t6.setError(null);
            return true;
        }
    }
    private Boolean validateThana(){
        String val = t7.getText().toString();

        if (val.isEmpty()){
            t7.setError("Field cannot be empty");
            return false;
        }
        else {
            t7.setError(null);
            return true;
        }
    }
    private Boolean validateWebsite(){
        String val = t8.getText().toString();

        if (val.isEmpty()){
            t8.setError("Field cannot be empty");
            return false;
        }
        else {
            t8.setError(null);
            return true;
        }
    }

    public  void registerUser(View view){

        if ( !validateName()  | !validatePhone() | !validateSeat() | !validateICUSeat()  | !validateAddress()
                | !validateDistrict() | !validateThana() | !validateWebsite()){
            return;
        }



        String name =t1.getText().toString();
        String address =t2.getText().toString();
        String seat =t3.getText().toString();
        String phone =t4.getText().toString();
        String icuSeat =t5.getText().toString();
        String district =t6.getText().toString();
        String thana =t7.getText().toString();
        String website =t8.getText().toString();

        addModel hospitalAddModel = new addModel(name,phone,seat,icuSeat,address,district,thana,website);
        reference.child(phone).setValue(hospitalAddModel);
    }



        private void checkInputs () {
            if (!TextUtils.isEmpty(t1.getText()) && validateName()) {
                if (!TextUtils.isEmpty(t2.getText()) && validateAddress()) {
                    if (!TextUtils.isEmpty(t3.getText()) && validateSeat()) {
                        if (!TextUtils.isEmpty(t4.getText()) && validatePhone()) {
                            if (!TextUtils.isEmpty(t5.getText()) && validateICUSeat()) {
                                if (!TextUtils.isEmpty(t6.getText()) && validateDistrict()){
                                    if (!TextUtils.isEmpty(t7.getText()) && validateThana()){
                                        if (!TextUtils.isEmpty(t8.getText()) && validateWebsite()){
                                            saveBtn.setEnabled(true);
                                            saveBtn.setTextColor(Color.rgb(255, 255, 255));
                                        }else {
                                            saveBtn.setEnabled(false);
                                            saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
                                        }

                                    }else{
                                        saveBtn.setEnabled(false);
                                        saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
                                    }

                                }else {
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
            } else {
                saveBtn.setEnabled(false);
                saveBtn.setTextColor(Color.argb(80, 255, 255, 255));
            }


        }




}
