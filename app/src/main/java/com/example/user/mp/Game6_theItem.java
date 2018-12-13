package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Game6_theItem extends Activity {
    private String lives;
    private TextView life;
    private int highscore;

    private float x1,x2,y1,y2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.game6_theitem);

       /*
        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);
        */

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
                    Intent myIntent =new Intent(Game6_theItem.this,Game6_cat.class);
                    startActivityForResult(myIntent, 0);
                }
                else if (x2>x1) //right
                {
                    Intent myIntent =new Intent(Game6_theItem.this,Game6_Pikachu.class);
                    startActivityForResult(myIntent, 0);
                }
                else if (y1<y2){
                    Intent myIntent =new Intent(Game6_theItem.this,Game6_key.class);
                    startActivityForResult(myIntent, 0);
                }
                else if (y2<y1){
                    Intent myIntent =new Intent(Game6_theItem.this,Game6.class);
                    startActivityForResult(myIntent, 0); //dont change
                }

        }
        return false;
    }

    public void nextto7(View view){

        Intent myIntent = new Intent(view.getContext(), Game7.class);

        myIntent.putExtra("lives", lives);

        startActivityForResult(myIntent, 0);
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

