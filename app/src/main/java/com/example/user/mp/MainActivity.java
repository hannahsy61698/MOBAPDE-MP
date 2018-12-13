package com.example.user.mp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button butt;
    private SQLiteDatabaseHandler db;
    private String highscore = "2";
    private List<Player> players;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(i == 1){
            db = new SQLiteDatabaseHandler(this);
            players = db.allPlayers();
            i = 2;
        }


        TextView next = findViewById(R.id.txtStart);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Game1.class);
                myIntent.putExtra("lives", "3");
                startActivityForResult(myIntent, 0);
            }
        });

        TextView score = findViewById(R.id.txthigh);
        score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add(highscore);
                if(players.isEmpty()) {
                    Intent myIntent = new Intent(view.getContext(), HighScore.class);
                    myIntent.putExtra("highname", "beep");
                    startActivityForResult(myIntent, 0);
                }else{
                    String msg = players.get(0).getName();
                    Intent myIntent = new Intent(view.getContext(), HighScore.class);
                    myIntent.putExtra("highname", msg);
                    myIntent.putExtra("score", highscore);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

// this is to exit the application
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
    }

    public void add(String high){
        if(getIntent().getStringExtra("score") == null){
            highscore = "0";
        }else {
            highscore = getIntent().getStringExtra("score");
        }
        int temp = Integer.parseInt(high);
        Player player1 = new Player(1, "Lebron James", "F", temp);
        db.addPlayer(player1);
        players = db.allPlayers();
    }

//    private boolean checkDataBase() {
//        SQLiteDatabase checkDB = null;
//        final String DB_FULL_PATH = "/data/data/com.example.user.mp/databases";
//        try {
//            checkDB = SQLiteDatabase.openDatabase(DB_FULL_PATH, null,
//                    SQLiteDatabase.OPEN_READONLY);
//            checkDB.close();
//        } catch (SQLiteException e) {
//
//        }
//        return checkDB != null;
//    }

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
