package com.example.user.mp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Game2 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2);

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
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "click!",
                        Toast.LENGTH_LONG).show();
            }
        });
        linearLayout.addView(img3);

    }

}
