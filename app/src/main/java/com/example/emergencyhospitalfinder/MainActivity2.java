package com.example.emergencyhospitalfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private CardView allHospitalCardView, nearestHospitalCardView, nearestPharmacyCardView, findAmbulanceCardView;
    private AppBarConfiguration mAppBarConfiguration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        allHospitalCardView = findViewById(R.id.allHospitalCardViewId);
        nearestHospitalCardView = findViewById(R.id.nearestHospitalCardViewId);
        nearestPharmacyCardView = findViewById(R.id.nearestPharmacyCardViewId);
        findAmbulanceCardView = findViewById(R.id.findAmbulanceCardViewId);

        allHospitalCardView.setOnClickListener(this);
        nearestHospitalCardView.setOnClickListener(this);
        nearestPharmacyCardView.setOnClickListener(this);
        findAmbulanceCardView.setOnClickListener(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();

         navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:

                        break;

                    case R.id.nav_gallery:
                        Intent i=new Intent(MainActivity2.this,AmbulanceAdminSignInActivity.class);
                        startActivity(i);
                        break;

                    case R.id.nav_slideshow:
                        Intent i1=new Intent(MainActivity2.this,BloodBankAdminSignInActivity.class);
                        startActivity(i1);
                        break;



                   case R.id.nav_superAdmin:
                        Intent i4=new Intent(MainActivity2.this,RegisterActivity.class);
                        startActivity(i4);
                        break;

                    case R.id.nav_admin:
                        Intent i5=new Intent(MainActivity2.this,AdminSignInActivity.class);
                        startActivity(i5);
                        break;

                    case R.id.nav_hospital:
                        Intent i6=new Intent(MainActivity2.this,MainActivity4.class);
                        startActivity(i6);
                        break;

                    case R.id.nav_bloodBank:
                        Intent i7=new Intent(MainActivity2.this,BloodBankUserActivity.class);
                        startActivity(i7);
                        break;

                    case R.id.nav_ambulance:
                        Intent i8=new Intent(MainActivity2.this,AmbulanceUserActivity.class);
                        startActivity(i8);
                        break;
                }

                drawer.closeDrawers();
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.allHospitalCardViewId)
        {
            Intent intent = new Intent(MainActivity2.this,HospitalUserHomeActivity.class);
            startActivity(intent);
        }
        else if(v.getId() ==R.id.nearestHospitalCardViewId)
        {
            Intent intent = new Intent(MainActivity2.this,HospitalMapsActivity.class);
            startActivity(intent);
        }
        else if(v.getId() ==R.id.nearestPharmacyCardViewId)
        {
            Intent intent = new Intent(MainActivity2.this,BloodBankUserHomeActivity.class);
            startActivity(intent);
        }
        else if(v.getId() ==R.id.findAmbulanceCardViewId)
        {
            Intent intent = new Intent(MainActivity2.this,AmbulanceUserHomeActivity.class);
            startActivity(intent);
        }
    }
}