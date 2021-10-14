package com.example.volleylib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private TextView textView ,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue= Volley.newRequestQueue(this);
        textView=findViewById(R.id.userid);
        textView2=findViewById(R.id.id);
        textView3=findViewById(R.id.tittle);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,
        "https://jsonplaceholder.typicode.com/todos/1",null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("JSON","onResponse"+response.getString("title"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error","onError"+error.getMessage());

            }
        });


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0; i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                      //  Log.d("JsonArray", "onResponse: "+jsonObject.getString("userId"));
                        textView.setText(jsonObject.getString("userId"));
                      textView2.setText(jsonObject.getString("id"));
                      textView3.setText(jsonObject.getString("title"));
                        boolean d=jsonObject.getBoolean("completed");


                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("JsonArray", "onErrorResponse: ");

            }
        });
          requestQueue.add(jsonArrayRequest);
        //requestQueue.add(jsonObjectRequest);
        //textView.setText((CharSequence) jsonArrayRequest));
    }
}