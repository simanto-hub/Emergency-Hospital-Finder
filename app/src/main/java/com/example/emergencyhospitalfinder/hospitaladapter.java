package com.example.emergencyhospitalfinder;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.zip.Inflater;

public class hospitaladapter extends FirebaseRecyclerAdapter<model,hospitaladapter.hospitalviewholder> {


    public hospitaladapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull hospitalviewholder holder, int position, @NonNull final model model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAddress());
        holder.t3.setText(model.getSeat());
        holder.t5.setText(model.getPhone());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new detailsfragment(model.getName(),model.getAddress(),model.getSeat(),model.getPhone())).addToBackStack(null).commit();
            }
        });


    }



    @NonNull
    @Override
    public hospitalviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new hospitalviewholder(view);
    }

    public class hospitalviewholder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3,t5;
        View view;


        public hospitalviewholder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
            t3=itemView.findViewById(R.id.t3);
            t5=itemView.findViewById(R.id.t5);
            view=itemView;



        }
    }
}
