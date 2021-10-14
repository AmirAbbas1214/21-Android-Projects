package com.example.senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dataRev extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_rev);
        textView=findViewById(R.id.textView);
       String value= getIntent().getStringExtra("amir");
       textView.setText(value);
    }
}