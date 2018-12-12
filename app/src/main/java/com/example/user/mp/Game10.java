package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Game10 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game10);

    }

    public void next(View view){
        Intent myIntent = new Intent(view.getContext(), Game11.class);
        startActivityForResult(myIntent, 0);
    }


}
