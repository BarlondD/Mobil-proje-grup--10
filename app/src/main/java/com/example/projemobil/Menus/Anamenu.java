package com.example.projemobil.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projemobil.Db.DB_Katmani;
import com.example.projemobil.R;

public class Anamenu extends AppCompatActivity {
public static DB_Katmani mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mdb = new DB_Katmani(this);
        Button btnplay = findViewById(R.id.Playbtn);
        Button btnScore = findViewById(R.id.Highscorebtn);
        Button btnHow  = findViewById(R.id.Nasıloynanırbtn);


        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ModMenu.class);
                startActivity(i);
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext() , SkorMenu.class);
                startActivity(i);
            }
        });
        btnHow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HowToPlay.class);
                startActivity(i);
            }
        });
    }
}
