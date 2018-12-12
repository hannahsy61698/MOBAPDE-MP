package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Game9 extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game9);

    }

    public void next(View view){
        Intent myIntent = new Intent(view.getContext(), Game10.class);
        startActivityForResult(myIntent, 0);
    }
}
