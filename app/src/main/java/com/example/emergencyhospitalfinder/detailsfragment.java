package com.example.emergencyhospitalfinder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class detailsfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    String name, address,seat,phone;
    public detailsfragment() {

    }

    public detailsfragment(String name,String address,String seat,String phone) {
        this.name=name;
        this.address=address;
        this.seat=seat;
        this.phone=phone;

    }


    public static detailsfragment newInstance(String param1, String param2) {
        detailsfragment fragment = new detailsfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detailsfragment, container, false);
       TextView t1=view.findViewById(R.id.t1);
        TextView t2=view.findViewById(R.id.t2);
        TextView t3=view.findViewById(R.id.t3);
        TextView t5=view.findViewById(R.id.t5);

        t1.setText(name);
        t2.setText(address);
        t3.setText(seat);
        t5.setText(phone);

        return view;
    }
    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).addToBackStack(null).commit();
    }
}