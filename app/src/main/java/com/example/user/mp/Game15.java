package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Game15 extends Activity

    {

        private String lives;
        private TextView life;
        private int highscore;

        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game15);

        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);

    }
        public void endGame (View view){

        Intent myIntent = new Intent(view.getContext(), Game14.class);

        myIntent.putExtra("lives", lives);

        startActivityForResult(myIntent, 0);
    }

        public void wrong15 (View view){
        int minus = Integer.parseInt(lives);
        minus = minus - 1;
        if (minus != 0) {
            lives = Integer.toString(minus);
            life.setText(lives);
        } else {
            highscore = 140;
            Intent myIntent = new Intent(view.getContext(), GameOver.class);
            myIntent.putExtra("score", "140");
            startActivityForResult(myIntent, 0);
        }
    }


        boolean doubleBackToExitPressedOnce = false;
        @Override
        public void onBackPressed() {
            if (doubleBackToExitPressedOnce) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Exit me", true);
                startActivity(intent);
                finish();

            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
//end here
    }