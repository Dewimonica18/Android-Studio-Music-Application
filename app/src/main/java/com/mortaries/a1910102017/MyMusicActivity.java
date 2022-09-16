package com.mortaries.a1910102017;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyMusicActivity extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("My Music");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable
                =new ColorDrawable(Color.parseColor("#2E86CE"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Button btnlagu1 = (Button) findViewById(R.id.lagu1);
        Button btnlagu2 = (Button) findViewById(R.id.lagu2);
        Button btnlagu3 = (Button) findViewById(R.id.lagu3);
        Button btnlagu4 = (Button) findViewById(R.id.lagu4);
        Button btnlagu5 = (Button) findViewById(R.id.lagu5);

        btnlagu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musik1 = new Intent(MyMusicActivity.this, MusicPlayerActivity.class);
                startActivity(musik1);
            }
        });
        btnlagu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musik2 = new Intent(MyMusicActivity.this, IndonesiaPusakaActivity.class);
                startActivity(musik2);
            }
        });
        btnlagu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musik3 = new Intent(MyMusicActivity.this, IndonesiaRayaActivity.class);
                startActivity(musik3);
            }
        });
        btnlagu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musik4 = new Intent(MyMusicActivity.this, MajuTakGentarActivity.class);
                startActivity(musik4);
            }
        });
        btnlagu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musik5 = new Intent(MyMusicActivity.this, RayuanPulauKelapaActivity.class);
                startActivity(musik5);
            }
        });
    }
}