package com.example.user.mp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Game13 extends Activity {

    private String lives;
    private TextView life;
    private int highscore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game11);

        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);

    }
}
