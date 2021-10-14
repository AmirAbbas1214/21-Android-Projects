package com.amirniqab.hdwallpapers2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Natural extends AppCompatActivity {
    GridView gridView;
    int[] Image = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
            R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10,
            R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15,
            R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20
            , R.drawable.image21, R.drawable.image22, R.drawable.image23, R.drawable.image24, R.drawable.image25
            , R.drawable.image26, R.drawable.image27, R.drawable.image28, R.drawable.image29, R.drawable.image30
            , R.drawable.image31, R.drawable.image32, R.drawable.image33, R.drawable.image34, R.drawable.image35
            , R.drawable.image36, R.drawable.image37, R.drawable.image38, R.drawable.image39, R.drawable.image40};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural);
        gridView = findViewById(R.id.gridView);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Natural_Full_Screen.class);
                intent.putExtra("image", Image[position]);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return Image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_data, null);
            ImageView image = view.findViewById(R.id.imageview);
            image.setImageResource(Image[position]);
            return view;
        }
    }
    }