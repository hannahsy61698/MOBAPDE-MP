package com.example.user.mp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Game3_0 extends Activity {

    private Button img;
    private Button next;
    private EditText text;
    private String lives;
    private int highscore;
    private TextView life;
    private View views;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game3_0);

        img = findViewById(R.id.clickmebtn);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Game3.class);
                startActivityForResult(myIntent, 0);
            }
        });

        next = findViewById(R.id.submitbtn);
        text = findViewById(R.id.character);

        lives = getIntent().getStringExtra("lives");
        life = findViewById(R.id.life_num);
        life.setText(lives);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                views = view;
                String txt = text.getText().toString();
//if(txt.equals("stitch") || txt.equals("STITCH") || txt.equals("Stitch"))
                if(txt.toLowerCase().equals("stitch")) {
                    highscore = 30;
                    Intent myIntent = new Intent(view.getContext(), Game4.class);
                    myIntent.putExtra("lives", lives);
                    startActivityForResult(myIntent, 0);
                } else{
                    wrong();
                }
            }
        });
    }

    public void wrong(){
        int minus = Integer.parseInt(lives);
        minus = minus - 1;
        if(minus != 0) {
            lives = Integer.toString(minus);
            life.setText(lives);
        }else
        {
            highscore = 20;
            Intent myIntent = new Intent(views.getContext(), GameOver.class);
            startActivityForResult(myIntent, 0);
        }
    }
}