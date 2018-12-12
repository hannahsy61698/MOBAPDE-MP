package com.example.user.mp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Game12  extends Activity {

    private String lives;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game11);

        lives = getIntent().getStringExtra("lives");
        TextView life = findViewById(R.id.life_num);
        life.setText(lives);

    }



}
