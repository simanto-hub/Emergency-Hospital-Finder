package com.example.emergencyhospitalfinder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class bloodbankpendingadapter extends FirebaseRecyclerAdapter<bloodbankModel,bloodbankpendingadapter.bloodbankpendingviewholder> {

    public bloodbankpendingadapter(@NonNull FirebaseRecyclerOptions<bloodbankModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final bloodbankpendingviewholder holder,final int position, @NonNull final bloodbankModel model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAddress());
        holder.t3.setText(model.getPhone());
        holder.t4.setText(model.getPassword());
        holder.t5.setText(model.getUsername());
        holder.t6.setText(model.getDistrict());
        holder.t7.setText(model.getThana());

        holder.accept.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(final View v) {

                holder.t1.setText(model.getName());
                holder.t2.setText(model.getAddress());
                holder.t3.setText(model.getPhone());
                holder.t4.setText(model.getPassword());
                holder.t5.setText(model.getUsername());
                holder.t6.setText(model.getDistrict());
                holder.t7.setText(model.getThana());


                String name =holder.t1.getText().toString().trim();
                String address =holder.t2.getText().toString().trim();
                String phone =holder.t3.getText().toString().trim();
                String password =holder.t4.getText().toString().trim();
                String username =holder.t5.getText().toString().trim();
                String district = holder.t6.getText().toString().trim();
                String thana = holder.t7.getText().toString().trim();






                bloodbankModel bloodbankAdminModel = new bloodbankModel(username,password,name,phone,address,district,thana);

                FirebaseDatabase.getInstance().getReference("Blood Bank").child(phone).setValue(bloodbankAdminModel);

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
                        FirebaseDatabase.getInstance().getReference().child("Blood Bank Pending")
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
    public bloodbankpendingviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bloodbankpendingsinglerow,parent,false);
        return new bloodbankpendingviewholder(view);
    }

    class bloodbankpendingviewholder extends RecyclerView.ViewHolder{
        EditText t1,t2,t3,t4,t5,t6,t7;
        Button accept,reject;

        public bloodbankpendingviewholder(@NonNull View itemView) {
            super(itemView);

            t1=(EditText) itemView.findViewById(R.id.t1);
            t2=(EditText) itemView.findViewById(R.id.t2);
            t3=(EditText) itemView.findViewById(R.id.t3);
            t4=(EditText) itemView.findViewById(R.id.t4);
            t5=(EditText) itemView.findViewById(R.id.t5);
            t6=(EditText) itemView.findViewById(R.id.t6);
            t7=(EditText) itemView.findViewById(R.id.t7);


            accept=(Button) itemView.findViewById(R.id.accept);
            reject=(Button) itemView.findViewById(R.id.reject);
        }
    }
}
