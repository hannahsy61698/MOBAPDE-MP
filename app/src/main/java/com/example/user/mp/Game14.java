package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game14 extends Activity {

    private String lives;
    private TextView life;
    private int highscore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game14);

        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);

    }

    public void nextto15(View view) {

        Intent myIntent = new Intent(view.getContext(), Game15.class);

        myIntent.putExtra("lives", lives);

        startActivityForResult(myIntent, 0);
    }

    public void wrong14(View view) {
        int minus = Integer.parseInt(lives);
        minus = minus - 1;
        if (minus != 0) {
            lives = Integer.toString(minus);
            life.setText(lives);
        } else {
            highscore = 130;
            Intent myIntent = new Intent(view.getContext(), GameOver.class);
            startActivityForResult(myIntent, 0);
        }
    }
}

