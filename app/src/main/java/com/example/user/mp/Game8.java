package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class Game8 extends Activity {

    private String lives;
    private Board View;
    private Engine Engine;
    private View views;
    private TextView life;
    private int highscore;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game8i);

        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);

        Button butt = findViewById(R.id.button);
        butt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                views = view;
                    next();
            }
        });

        // this is to exit the application
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
    }

    public void next(){
        setContentView(R.layout.game8);
        View = findViewById(R.id.board);

        Engine = new Engine();
        View.setGameEngine(Engine);
        View.setMainActivity(this);
    }

    public void gameEnded(char c) {

        if(c == 'T'){
            String msg = "New Game! No ties!";
            new AlertDialog.Builder(this).setTitle("Tic Tac Toe")
                    .setMessage(msg)
                    .setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            newGame();
                        }
                    })
                    .show();
        }
        else if(c == 'X'){
            String msg = "You won!";
            new AlertDialog.Builder(this).setTitle("Tic Tac Toe")
                    .setMessage(msg)
                    .setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Intent myIntent = new Intent(views.getContext(), Game9.class);
                            myIntent.putExtra("lives", lives);
                            startActivityForResult(myIntent, 0);
                        }
                    })
                    .show();
        }else{
            String msg = "You lost";
            new AlertDialog.Builder(this).setTitle("Tic Tac Toe")
                    .setMessage(msg)
                    .setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            newGame();
                        }
                    })
                    .show();
        }

    }

    private void newGame() {
        Engine.newGame();
        View.invalidate();
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
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
}