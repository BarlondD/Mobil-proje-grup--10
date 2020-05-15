package com.example.projemobil.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projemobil.Klasik.Kolay;
import com.example.projemobil.Klasik.Normal;
import com.example.projemobil.Klasik.Zor;
import com.example.projemobil.R;

public class KlasikMenu extends AppCompatActivity {
    public static int bomba=0;
    public static int genislik=0;
    public static int uzunluk=0;
    public static String mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasik_menu);
        mod="klasik";
        HizliMenu.mod="";
        Button kolay =findViewById(R.id.Kolaybtn);
        Button normal=findViewById(R.id.Normalbtn);
        Button zor =findViewById(R.id.Zorbtn);

        kolay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=3;
                genislik=9;
                uzunluk=14;

                Intent i = new Intent(getApplicationContext(), Kolay.class);

                startActivity(i);
            }

        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=40;
                genislik=15;
                uzunluk=20;

                Intent i= new Intent(getApplicationContext(), Normal.class);
                startActivity(i);
            }
        });
        zor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=99;
                genislik=19;
                uzunluk=26;


                Intent i = new Intent(getApplicationContext(),Zor.class);
                startActivity(i);
            }
        });


    }
    @Override
    public void onBackPressed() {

        Intent i = new Intent(getApplicationContext(),ModMenu.class);
        startActivity(i);
    }
}
