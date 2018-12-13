package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighScore extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        TextView high1 = findViewById(R.id.high1);
        TextView high2 = findViewById(R.id.high2);
        TextView high3 = findViewById(R.id.high3);

        if(getIntent().getStringExtra("highname") == null) {
                high1.setText("null");
                high2.setText("null");
                high2.setText("null");
        }else{
            String num1 = getIntent().getStringExtra("highname");
            String score1 = getIntent().getStringExtra("score");
            high1.setText(num1 + ":   " + score1);

            String num2 = getIntent().getStringExtra("highname2");
            String score2 = getIntent().getStringExtra("score");
            high2.setText(num2 + ":   " + score2);

            String num3 = getIntent().getStringExtra("highname3");
            String score3 = getIntent().getStringExtra("score");
            high3.setText(num3 + ":   " + score3);
        }

        TextView back = findViewById(R.id.txtback);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
