package com.example.emergencyhospitalfinder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentSnapshot;

public class myadapter extends FirebaseRecyclerAdapter<addModel,myadapter.myviewholder> {



    public myadapter( @NonNull FirebaseRecyclerOptions<addModel> options) {


        super(options);


    }



    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final addModel model) {

        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAddress());
        holder.t3.setText(model.getSeat());
        holder.t4.setText(model.getIcuSeat());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),HospitalDetailsUserActivity.class);

                intent.putExtra("name",model.getName());
                intent.putExtra("address",model.getAddress());
                intent.putExtra("seat",model.getSeat());
                intent.putExtra("phone",model.getPhone());
                intent.putExtra("icuSeat",model.getIcuSeat());
                intent.putExtra("website",model.getWebsite());
                v.getContext().startActivity(intent);
            }
        });



    }




    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3,t4;



        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.t1);
            t2=(TextView)itemView.findViewById(R.id.t2);
            t3=(TextView)itemView.findViewById(R.id.t3);
            t4=(TextView)itemView.findViewById(R.id.t4);



        }
    }

}
