package com.mortaries.a1910102017;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Lagu Nasional Playlist");
        ColorDrawable colorDrawable
                =new ColorDrawable(Color.parseColor("#5BBDEB"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button btngetstart = (Button) findViewById(R.id.getstarted);

        btngetstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getstart = new Intent(MainActivity.this,MyMusicActivity.class);
                startActivity(getstart);

            }
        });
    }
}