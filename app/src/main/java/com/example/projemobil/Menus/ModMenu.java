package com.example.projemobil.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projemobil.R;

public class ModMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_menu);
        Button btnklasik = findViewById(R.id.btnklasik);
        btnklasik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), KlasikMenu.class);
                startActivity(i);
            }
        });

        Button btnhizli = findViewById(R.id.btnhizli);
        btnhizli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HizliMenu.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent i = new Intent(getApplicationContext(),Anamenu.class);
        startActivity(i);
    }
}

