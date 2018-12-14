package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameWin extends Activity {

    private Button butts;
    private String score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamewin);

        butts = findViewById(R.id.button5);

    }

    public void restart(View view){
        score = getIntent().getStringExtra("score");

        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        myIntent.putExtra("score", score);
        startActivityForResult(myIntent, 0);
    }
}