package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class Game6 extends Activity {
    private String lives;
    private TextView life;
    private int highscore;

    private float x1,x2,y1,y2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game6);




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
                if(x1<x2){
                    Intent myIntent =new Intent(Game6.this,Game6_theItem.class);
                    startActivityForResult(myIntent, 0);
                }

        }
        return false;
    }
}
