package com.example.senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nameid);
        send=findViewById(R.id.buttonid);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data=name.getText().toString().trim();
                if (!data.isEmpty()){
                Intent intent=new Intent(MainActivity.this,dataRev.class);
                intent.putExtra("amir",data);
                startActivity(intent);}
                else {
                    Toast.makeText(MainActivity.this,"Name is Empty",Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
    }
}