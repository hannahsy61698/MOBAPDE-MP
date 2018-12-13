package com.example.user.mp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button butt;
    private SQLiteDatabaseHandler db;
    private String stopper;
    private String highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopper = "start";

        if(checkDataBase()){
            db = new SQLiteDatabaseHandler(this);
        }else{
            highscore = getIntent().getStringExtra("score");
            add(highscore);
        }

        TextView next = findViewById(R.id.txtStart);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Game1.class);
                myIntent.putExtra("lives", "3");
                startActivityForResult(myIntent, 0);
            }
        });


// this is to exit the application
        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            return; // add this to prevent from doing unnecessary stuffs
        }
    }

    public void add(String high){
        Player player1 = new Player(1, "Lebron James", "F", Integer.parseInt(high));

        db.addPlayer(player1);

        List<Player> players = db.allPlayers();

        if (players != null) {
            String msg = players.get(0).getName() + players.get(0).getHeight();
            TextView text = findViewById(R.id.high1);
            text.setText(msg);
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        final String DB_FULL_PATH = "/data/data/com.example.user.mp/databases";
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_FULL_PATH, null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
        }
        return checkDB != null;
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
