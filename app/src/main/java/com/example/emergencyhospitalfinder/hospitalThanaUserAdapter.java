package com.example.emergencyhospitalfinder;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class hospitalThanaUserAdapter extends FirebaseRecyclerAdapter<addModel,hospitalThanaUserAdapter.thanauserviewholder> {
    public hospitalThanaUserAdapter(@NonNull FirebaseRecyclerOptions<addModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull thanauserviewholder holder, int position, @NonNull final  addModel model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getThana());
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
    public thanauserviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hospitalthanausersinglerow,parent,false);
        return new thanauserviewholder(view);
    }

    class thanauserviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4;

        public thanauserviewholder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.t1);
            t2=(TextView)itemView.findViewById(R.id.t2);
            t3=(TextView)itemView.findViewById(R.id.t3);
            t4=(TextView)itemView.findViewById(R.id.t4);


        }
    }
}
