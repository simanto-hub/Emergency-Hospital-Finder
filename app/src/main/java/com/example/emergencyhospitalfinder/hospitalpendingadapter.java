package com.example.emergencyhospitalfinder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class hospitalpendingadapter extends FirebaseRecyclerAdapter<hospitalAdmin,hospitalpendingadapter.hospitalpendingviewholder> {

    public hospitalpendingadapter(@NonNull FirebaseRecyclerOptions<hospitalAdmin> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final hospitalpendingviewholder holder,final int position, @NonNull final hospitalAdmin model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAddress());
        holder.t3.setText(model.getSeat());
        holder.t4.setText(model.getIcuSeat());
        holder.t5.setText(model.getPhone());
        holder.t6.setText(model.getPassword());
        holder.t7.setText(model.getUsername());
        holder.t8.setText(model.getDistrict());
        holder.t9.setText(model.getThana());
        holder.t10.setText(model.getWebsite());



        holder.accept.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(final View v) {

                holder.t1.setText(model.getName());
                holder.t2.setText(model.getAddress());
                holder.t3.setText(model.getSeat());
                holder.t4.setText(model.getIcuSeat());
                holder.t5.setText(model.getPhone());
                holder.t6.setText(model.getPassword());
                holder.t7.setText(model.getUsername());
                holder.t8.setText(model.getDistrict());
                holder.t9.setText(model.getThana());
                holder.t10.setText(model.getWebsite());


                String name =holder.t1.getText().toString().trim();
                String address =holder.t2.getText().toString().trim();
                String seat =holder.t3.getText().toString().trim();
                String icuSeat =holder.t4.getText().toString().trim();
                String phone =holder.t5.getText().toString().trim();
                String password =holder.t6.getText().toString().trim();
                String username =holder.t7.getText().toString().trim();
                String district =holder.t8.getText().toString().trim();
                String thana =holder.t9.getText().toString().trim();
                String website =holder.t10.getText().toString().trim();







                hospitalAdmin hospitalAdminModel = new hospitalAdmin(username,password,name,phone,seat,icuSeat,address,district,thana,website);

               FirebaseDatabase.getInstance().getReference("Hospitals").child(phone).setValue(hospitalAdminModel);

                Toast.makeText(v.getContext(),"Data is updated",Toast.LENGTH_LONG).show();


            }
        });

        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.reject.getContext());
                builder.setTitle("Reject Panel");
                builder.setMessage("Want to reject?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Pending Hospital")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public hospitalpendingviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hospitalpendingsinglerow,parent,false);
        return new hospitalpendingviewholder(view);
    }

    class hospitalpendingviewholder extends RecyclerView.ViewHolder{

        EditText t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
        Button accept,reject;

        FirebaseDatabase rootNode;
        DatabaseReference reference;

        public hospitalpendingviewholder(@NonNull View itemView) {
            super(itemView);

            t1=(EditText) itemView.findViewById(R.id.t1);
            t2=(EditText) itemView.findViewById(R.id.t2);
            t3=(EditText) itemView.findViewById(R.id.t3);
            t4=(EditText) itemView.findViewById(R.id.t4);
            t5=(EditText) itemView.findViewById(R.id.t5);
            t6=(EditText) itemView.findViewById(R.id.t6);
            t7=(EditText) itemView.findViewById(R.id.t7);
            t8=(EditText) itemView.findViewById(R.id.t8);
            t9=(EditText) itemView.findViewById(R.id.t9);
            t10=(EditText) itemView.findViewById(R.id.t10);

            accept=(Button) itemView.findViewById(R.id.accept);
            reject=(Button) itemView.findViewById(R.id.reject);

        }
    }
}
