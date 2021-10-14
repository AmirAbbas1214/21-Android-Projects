package com.example.fragmenttoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name,email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                MyFirstFragment myFirstFragment=new MyFirstFragment();
                fragmentTransaction.add(R.id.liner,myFirstFragment);
                fragmentTransaction.commit();

            }
        });

    }


    public void takeData(String userName,String useEmail){

        name=findViewById(R.id.textname);
        email=findViewById(R.id.textemail);

        name.setText(userName);
        email.setText(useEmail);

    }
}