package com.example.emergencyhospitalfinder;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ambulanceDistrictUserAdapter extends FirebaseRecyclerAdapter<amulancemodel,ambulanceDistrictUserAdapter.districtUserviewholder> {
    public ambulanceDistrictUserAdapter(@NonNull FirebaseRecyclerOptions<amulancemodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull districtUserviewholder holder, int position, @NonNull final amulancemodel model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getDistrict());
        holder.t3.setText(model.getAddress());

        holder.call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = model.getPhone();
                Log.d("TAG", "Working");
                String uri = "tel:"+phone.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                v.getContext().startActivity(intent);

            }
        });
    }

    @NonNull
    @Override
    public districtUserviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ambulancedistrictsinglerow,parent,false);
        return new  districtUserviewholder(view);
    }

    class districtUserviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView call_btn;
        public districtUserviewholder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.t1);
            t2=(TextView)itemView.findViewById(R.id.t2);
            t3=(TextView)itemView.findViewById(R.id.t3);

            call_btn=(ImageView) itemView.findViewById(R.id.call_btn);
        }
    }
}
