package com.example.emergencyhospitalfinder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class adminadapter extends FirebaseRecyclerAdapter<adminadapterModel,adminadapter.adminviewholder> {

    public adminadapter(@NonNull FirebaseRecyclerOptions<adminadapterModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final adminviewholder holder, final int position, @NonNull final adminadapterModel model) {

        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAddress());
        holder.t3.setText(model.getSeat());
        holder.t4.setText(model.getIcuSeat());
        holder.t5.setText(model.getPhone());

        holder.edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.edittext.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true,1800)
                        .create();
                View adminview=dialogPlus.getHolderView();
                final EditText name=adminview.findViewById(R.id.t1);
                final EditText address=adminview.findViewById(R.id.t2);
                final EditText seat=adminview.findViewById(R.id.t3);
                final EditText icuSeat=adminview.findViewById(R.id.t4);
                final EditText phone=adminview.findViewById(R.id.t5);
                final EditText district=adminview.findViewById(R.id.t6);
                final EditText thana=adminview.findViewById(R.id.t7);
                final EditText website=adminview.findViewById(R.id.t8);

                Button hsubmit=adminview.findViewById(R.id.hsubmit);

                name.setText(model.getName());
                address.setText(model.getAddress());
                seat.setText(model.getSeat());
                icuSeat.setText(model.getIcuSeat());
                phone.setText(model.getPhone());
                district.setText(model.getDistrict());
                thana.setText(model.getThana());
                website.setText(model.getWebsite());

                dialogPlus.show();

                hsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("address",address.getText().toString());
                        map.put("seat",seat.getText().toString());
                        map.put("phone",phone.getText().toString());
                        map.put("icuSeat",icuSeat.getText().toString());
                        map.put("district",district.getText().toString());
                        map.put("thana",thana.getText().toString());
                        map.put("website",website.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Hospitals")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

        holder.deletetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.deletetext.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Want to delete?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Hospitals")
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
    public adminviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adminsinglerow,parent,false);
        return new adminviewholder(view);
    }

    class adminviewholder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3,t4,t5,t6,t7,t8;
        TextView edittext,deletetext;
        public adminviewholder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.t1);
            t2=(TextView)itemView.findViewById(R.id.t2);
            t3=(TextView)itemView.findViewById(R.id.t3);
            t4=(TextView)itemView.findViewById(R.id.t4);
            t5=(TextView)itemView.findViewById(R.id.t5);
            t6=(TextView)itemView.findViewById(R.id.t6);
            t7=(TextView)itemView.findViewById(R.id.t7);
            t8=(TextView)itemView.findViewById(R.id.t8);

            edittext=(TextView)itemView.findViewById(R.id.edittext);
            deletetext=(TextView)itemView.findViewById(R.id.deletetext);


        }
    }
}
