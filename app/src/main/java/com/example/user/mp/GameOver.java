package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends Activity {

    private Button butts;
    private String score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        butts = findViewById(R.id.button2);
        score = getIntent().getStringExtra("score");
    }

    public void restart(View view){
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        myIntent.putExtra("score", score);
        startActivityForResult(myIntent, 0);
    }
}
