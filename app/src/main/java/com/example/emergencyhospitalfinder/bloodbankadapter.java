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

public class bloodbankadapter extends FirebaseRecyclerAdapter<amulancemodel,bloodbankadapter.bloodbankviewholder> {
    public bloodbankadapter(@NonNull FirebaseRecyclerOptions<amulancemodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final bloodbankviewholder holder, final int position, @NonNull final amulancemodel model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAddress());
        holder.t3.setText(model.getPhone());


        holder.edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.edittext.getContext())
                        .setContentHolder(new ViewHolder(R.layout.bloodbankdialogcontent))
                        .setExpanded(true,1500)
                        .create();
                View adminview=dialogPlus.getHolderView();
                final EditText t1=adminview.findViewById(R.id.t1);
                final EditText t2=adminview.findViewById(R.id.t2);
                final EditText t3=adminview.findViewById(R.id.t3);
                final EditText t4=adminview.findViewById(R.id.t4);
                final EditText t5=adminview.findViewById(R.id.t5);

                Button hsubmit=adminview.findViewById(R.id.hsubmit);

                t1.setText(model.getName());
                t2.setText(model.getAddress());
                t3.setText(model.getPhone());
                t4.setText(model.getDistrict());
                t5.setText(model.getThana());

                dialogPlus.show();

                hsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("name",t1.getText().toString());
                        map.put("address",t2.getText().toString());
                        map.put("phone",t3.getText().toString());
                        map.put("district",t4.getText().toString());
                        map.put("thana",t5.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("Blood Bank")
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
                        FirebaseDatabase.getInstance().getReference().child("Blood Bank")
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
    public bloodbankviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bloodbanksinglerow,parent,false);
        return  new bloodbankviewholder(view);
    }

    class bloodbankviewholder extends RecyclerView.ViewHolder{

        TextView t1,t2,t3,t4,t5;
        TextView edittext,deletetext;
        public bloodbankviewholder(@NonNull View itemView) {
            super(itemView);

            t1=(TextView)itemView.findViewById(R.id.t1);
            t2=(TextView)itemView.findViewById(R.id.t2);
            t3=(TextView)itemView.findViewById(R.id.t3);
            t4=(TextView)itemView.findViewById(R.id.t4);
            t5=(TextView)itemView.findViewById(R.id.t5);

            edittext=(TextView)itemView.findViewById(R.id.edittext);
            deletetext=(TextView)itemView.findViewById(R.id.deletetext);
        }
    }
}
