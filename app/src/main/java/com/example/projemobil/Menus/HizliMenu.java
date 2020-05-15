package com.example.projemobil.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.projemobil.Hızlı.Level1;
import com.example.projemobil.Hızlı.Level2;
import com.example.projemobil.Hızlı.Level3;
import com.example.projemobil.Hızlı.Level4;
import com.example.projemobil.Hızlı.Level5;
import com.example.projemobil.R;

import android.view.View;
import android.widget.Button;

import android.database.Cursor;
public class HizliMenu extends AppCompatActivity {
    public static int bomba=0;
    public static int genislik=0;
    public static int uzunluk=0;
    public static String mod;
    int lv2,lv3,lv4,lv5;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hizli_menu);
        mod="hizli";
        KlasikMenu.mod="";
        Button btnlv1 = findViewById(R.id.btnlv1);
      db=  Anamenu.mdb.getWritableDatabase();
              Cursor c = db.rawQuery("SELECT * FROM LEVELS ",null);
      c.moveToFirst();
              lv2=c.getInt(0);
      lv3=c.getInt(1);
      lv4=c.getInt(2);
      lv5=c.getInt(3);
        Button btnlv2 = findViewById(R.id.btnlv2);
        Button btnlv3 = findViewById(R.id.btnlv3);
        Button btnlv4 = findViewById(R.id.btnlv4);
        Button btnlv5 = findViewById(R.id.btnlv5);

        btnlv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=10;
                uzunluk=14;
                genislik=9;

                Intent i= new Intent(getApplicationContext(), Level1.class);
                startActivity(i);
            }
        });

        btnlv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bomba=15;
                uzunluk=14;
                genislik=9;
if(lv2==1){
                Intent i= new Intent(getApplicationContext(), Level2.class);
                startActivity(i);}

            }
        });
        btnlv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=30;
                uzunluk=20;
                genislik=15;
                if(lv3==1){
                Intent i= new Intent(getApplicationContext(), Level3.class);
                startActivity(i);}
            }
        });
        btnlv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=45;
                uzunluk=20;
                genislik=15;
                if(lv4==1){
                Intent i= new Intent(getApplicationContext(), Level4.class);
                startActivity(i);}
            }
        });
        btnlv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bomba=99;
                uzunluk=26;
                genislik=19;
                if(lv5==1){
                Intent i= new Intent(getApplicationContext(), Level5.class);
                startActivity(i);}
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent i = new Intent(getApplicationContext(),ModMenu.class);
        startActivity(i);
    }
}
