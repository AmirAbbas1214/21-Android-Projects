package com.example.fragmenttoactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;


public class MyFirstFragment extends Fragment {

    EditText name ,email;
    Button send;


    public MyFirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_my_first,container,false);
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        send=view.findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=name.getText().toString();
                String userEmail=email.getText().toString();
                MainActivity mainActivity=(MainActivity) getActivity();
                mainActivity.takeData(userName,userEmail);


            }
        });
        return view;
    }
}