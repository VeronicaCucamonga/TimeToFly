package com.example.shootergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;
    TextView HighScore_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        findViewById(R.id.play_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });

        HighScore_Text = findViewById(R.id.highscore_text);

        SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        HighScore_Text.setText("HighScore: "+ prefs.getInt("highscore", 0));

        isMute = prefs.getBoolean("isMute", false);

        ImageView volumeCtrl = findViewById(R.id.volume_ctrl);

        if(isMute)
            volumeCtrl.setImageResource(R.drawable.ic_volume_off_24);
        else
            volumeCtrl.setImageResource(R.drawable.ic_volume_up_24);

        volumeCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMute = !isMute;
                if(isMute)
                    volumeCtrl.setImageResource(R.drawable.ic_volume_off_24);
                else
                    volumeCtrl.setImageResource(R.drawable.ic_volume_up_24);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();
            }
        });
    }
}