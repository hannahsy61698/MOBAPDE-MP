package com.example.user.mp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Game3_0 extends Activity {

    private Button img;
    private Button next;

    private EditText text;

    private String lives;

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

        final String txt = text.getText().toString();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt.equals("stitch") || txt.equals("STITCH") || txt.equals("Stitch")) {
                    Intent myIntent = new Intent(view.getContext(), Game4.class);
                    myIntent.putExtra("lives", lives);
                    startActivityForResult(myIntent, 0);
                }


            }
        });




    }




}