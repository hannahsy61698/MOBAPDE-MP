package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game9 extends Activity {

    private String lives;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game9);

        lives = getIntent().getStringExtra("lives");
        TextView life = findViewById(R.id.life_num);
        life.setText(lives);
    }

    public void next(View view){
        Intent myIntent = new Intent(view.getContext(), Game10.class);
        myIntent.putExtra("lives", lives);
        startActivityForResult(myIntent, 0);
    }
}
