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

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Admin_Activity extends AppCompatActivity {


  EditText t1,t2,t3,t4,t5,t6;
  Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_);

        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
        t6=(EditText)findViewById(R.id.t6);


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

        saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                processinsert();
            }
        });

    }


    public void processinsert()
    {
        t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        t5=(EditText)findViewById(R.id.t5);
        t6=(EditText)findViewById(R.id.t6);


        String name=t1.getText().toString().trim();
        String hospitalName=t2.getText().toString().trim();
        String address=t3.getText().toString().trim();
        String seat=t4.getText().toString().trim();
        String phone=t5.getText().toString().trim();
        String icuSeat=t6.getText().toString().trim();

        dataholder obj=new dataholder(name,address,seat,phone,icuSeat);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("Hospitals");

        node.child(name).setValue(obj);

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        Toast.makeText(getApplicationContext(),"Value Inserted",Toast.LENGTH_LONG).show();


    }

    private void checkInputs () {
        if (!TextUtils.isEmpty(t1.getText())) {
            if (!TextUtils.isEmpty(t2.getText())) {
                if (!TextUtils.isEmpty(t3.getText())) {
                    if (!TextUtils.isEmpty(t4.getText())) {
                        if (!TextUtils.isEmpty(t5.getText())) {
                            if (!TextUtils.isEmpty(t6.getText())){
                                saveBtn.setEnabled(true);
                                saveBtn.setTextColor(Color.rgb(255, 255, 255));
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

