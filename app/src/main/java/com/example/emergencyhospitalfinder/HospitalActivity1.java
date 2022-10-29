package com.example.emergencyhospitalfinder;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import com.firebase.client.DataSnapshot;
        import com.firebase.client.Firebase;
        import com.firebase.client.FirebaseError;
        import com.firebase.client.ValueEventListener;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.MapFragment;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.android.gms.maps.model.Polyline;



public class HospitalActivity1 extends AppCompatActivity  {
    Button callBtn;
    Button websiteBtn;
    Firebase firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital1);

        final TextView textView1 = (TextView)findViewById(R.id.hospitalSeat_1);

        Firebase.setAndroidContext(getApplicationContext());

        firebase = new Firebase("https://hospital-seat-default-rtdb.firebaseio.com/Seat");
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String childText = dataSnapshot.getValue(String.class);
                textView1.setText(childText);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                textView1.setText("Error found!");

            }
        });



        websiteBtn = findViewById(R.id.website_btn);


        callBtn =findViewById(R.id.call_btn);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09666-710678"));
                startActivity(intent);
            }
        });

        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.evercarebd.com/");
            }

            private void gotoUrl(String s) {
                Uri uri =Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });



    }
    public void btnFindLocation(View view){

        startActivity(new Intent(this,MapsActivity2.class));
    }
}