package com.example.projemobil.Menus;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projemobil.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class LoseMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_menu);
        Button donbtn = findViewById(R.id.anamenulbtn);
        donbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Anamenu.class);
                startActivity(i);
            }
        });
    }
}
