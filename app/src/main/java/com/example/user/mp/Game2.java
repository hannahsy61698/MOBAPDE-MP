package com.example.user.mp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game2 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2);

//        TextView life = findViewById(R.id.life_num);
//        life.setText(getIntent().getStringExtra("lives"));

        LinearLayout linearLayout = findViewById(R.id.mainlayout);
        ImageView img1 = new ImageView(this);
        img1.setImageResource(R.drawable.squid_0);
        linearLayout.addView(img1);
        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.squid_1);
        linearLayout.addView(img2);

for (int i =0 ;i<50;i++)
        {
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.squid_2);
            linearLayout.addView(img);
        }

        ImageView img3 = new ImageView(this);
        img3.setImageResource(R.drawable.squid_3);
        img3.setClickable(true);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Game3.class);
                startActivityForResult(myIntent, 0);
            }
        });
        linearLayout.addView(img3);


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
