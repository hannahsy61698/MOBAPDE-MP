package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game10 extends Activity {

    private String lives;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game10);

        lives = getIntent().getStringExtra("lives");
        TextView life = findViewById(R.id.life_num);
        life.setText(lives);
    }

    public void next(View view){
        Intent myIntent = new Intent(view.getContext(), Game11.class);
        myIntent.putExtra("lives", lives);
        startActivityForResult(myIntent, 0);
    }


}
