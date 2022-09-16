package com.mortaries.a1910102017;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class RayuanPulauKelapaActivity extends AppCompatActivity {
    TextView playerPosition, playerDuration;
    SeekBar seekBar;
    ImageView btnplay, btnpause, btnnext, btnprev;

    MediaPlayer player;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rayuan_pulau_kelapa);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Music Play");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable
                =new ColorDrawable(Color.parseColor("#607D9B"));
        actionBar.setBackgroundDrawable(colorDrawable);

        playerPosition = findViewById(R.id.playerpos);
        playerDuration = findViewById(R.id.playerdur);
        seekBar = findViewById(R.id.seekbar);
        btnplay = findViewById(R.id.btnplay);
        btnpause = findViewById(R.id.btnpause);
        btnnext = findViewById(R.id.nextbtn);
        btnprev = findViewById(R.id.prevbtn);

        player = MediaPlayer.create(this, R.raw.rayuan_pulau_kelapa);

        runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(player.getCurrentPosition());
                handler.postDelayed(this, 500);
            }
        };

        int duration = player.getDuration();

        String sDuration = convertFormat(duration);
        playerDuration.setText(sDuration);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnplay.setVisibility(View.GONE);
                btnpause.setVisibility(View.VISIBLE);
                player.start();
                seekBar.setMax(player.getDuration());
                handler.postDelayed(runnable, 0);
            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnpause.setVisibility(View.GONE);
                btnplay.setVisibility(View.VISIBLE);
                player.pause();
                handler.removeCallbacks(runnable);
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                Intent next = new Intent(RayuanPulauKelapaActivity.this, MusicPlayerActivity.class);
                startActivity(next);
            }
        });
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                Intent prev = new Intent(RayuanPulauKelapaActivity.this, MajuTakGentarActivity.class);
                startActivity(prev);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    player.seekTo(progress);
                }
                playerPosition.setText(convertFormat(player.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btnpause.setVisibility(View.GONE);
                btnplay.setVisibility(View.VISIBLE);
                player.seekTo(0);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}