package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game6_cat extends Activity {
    private String lives;
    private TextView life;
    private int highscore;

    private float x1,x2,y1,y2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game6_cat);

       /*
        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);
        */

        ImageView img3 = new ImageView(this);
        img3.setImageResource(R.drawable.cat);
        img3.setClickable(true);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int minus = Integer.parseInt(lives);
                minus = minus - 1;
                if(minus != 0) {
                    lives = Integer.toString(minus);
                    life.setText(lives);
                }else
                {
                    highscore = 50;
                    Intent myIntent = new Intent(view.getContext(), GameOver.class);
                    myIntent.putExtra("score", "120");
                    startActivityForResult(myIntent, 0);
                }
            }
        });


    }
    public boolean onTouchEvent(MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1=touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2=touchevent.getX();
                y2=touchevent.getY();
                if(x1<x2){ //left
                    Intent myIntent =new Intent(Game6_cat.this,Game6_Pikachu.class);
                    startActivityForResult(myIntent, 0);
                }
                else if (x2>x1) //right
                {
                    Intent myIntent =new Intent(Game6_cat.this,Game6_theItem.class);
                    startActivityForResult(myIntent, 0);
                }
                else if (y1<y2){
                    Intent myIntent =new Intent(Game6_cat.this,Game6.class);
                    startActivityForResult(myIntent, 0);//no change
                }
                else if (y2<y1){
                    Intent myIntent =new Intent(Game6_cat.this,Game6_key.class);
                    startActivityForResult(myIntent, 0);
                }

        }
        return false;
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

