package com.amirniqab.hdwallpapers2022;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class Natural_Full_Screen extends AppCompatActivity {
ImageView imageView;
WallpaperManager wallpaperManager;
    Bitmap bitmap1, bitmap2;
    DisplayMetrics displayMetrics;
    int width,height;
    BitmapDrawable bitmapDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural_full_screen);
        imageView = findViewById(R.id.imageview12);

        wallpaperManager = wallpaperManager.getInstance(getApplicationContext());
        bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        bitmap1 = bitmapDrawable.getBitmap();
        Button button = findViewById(R.id.setwallpaper);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Natural_Full_Screen.this, "Wallpaper set Succussefully", Toast.LENGTH_LONG).show();
                GetScreenWidthHeight();
                setBitmapSizw();

                wallpaperManager = WallpaperManager.getInstance(Natural_Full_Screen.this);

                try {
                    wallpaperManager.setBitmap(bitmap2);
                    wallpaperManager.suggestDesiredDimensions(width, height);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });


        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            int selectedImage = intent.getIntExtra("image", 5);
            imageView.setImageResource(selectedImage);
            bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
            bitmap1 = bitmapDrawable.getBitmap();
            imageView.setImageBitmap(bitmap1);

        }
    }
        private void setBitmapSizw() {

            bitmap2=Bitmap.createScaledBitmap(bitmap1,width,height,false);
        }

        private void GetScreenWidthHeight() {
            displayMetrics=new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

            width=displayMetrics.widthPixels;
            height=displayMetrics.heightPixels;

    }

}