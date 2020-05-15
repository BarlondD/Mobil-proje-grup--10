package com.example.projemobil.Menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projemobil.Db.DB_Katmani;
import com.example.projemobil.Hızlı.Level1;
import com.example.projemobil.Hızlı.Level2;
import com.example.projemobil.Hızlı.Level3;
import com.example.projemobil.Hızlı.Level4;
import com.example.projemobil.Hızlı.Level5;
import com.example.projemobil.Klasik.Kolay;
import com.example.projemobil.Klasik.Normal;
import com.example.projemobil.Klasik.Zor;
import com.example.projemobil.R;

public class WinMenu extends AppCompatActivity {
    TextView suretxt;
    Button menubtn;
String isim;
int sure;
    EditText et;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_menu);
db=Anamenu.mdb.getWritableDatabase();
        suretxt= findViewById(R.id.suretxt);
        menubtn = findViewById(R.id.btnmenudon);
        et = findViewById(R.id.adtxt);
        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(KlasikMenu.mod=="klasik"){
                isim = et.getText().toString();
                Anamenu.mdb.insertSCORE(isim,sure);}
                Intent i = new Intent(getApplicationContext(), Anamenu.class);
                startActivity(i);
            }
        });
if (Level1.Bu==1){
    suretxt.setText(""+Level1.sayıcıs);
    db.execSQL("UPDATE LEVELS SET LV2=1 ");


}else if (Level2.Bu==1){
    suretxt.setText(""+Level2.sayıcıs);
    db.execSQL("UPDATE LEVELS SET LV3=1 ");
} else if (Level3.Bu==1){
    suretxt.setText(""+Level3.sayıcıs);
    db.execSQL("UPDATE LEVELS SET LV4=1 ");
} else if (Level4.Bu==1){
    suretxt.setText(""+Level4.sayıcıs);
    db.execSQL("UPDATE LEVELS SET LV5=1 ");
}else if (Level5.Bu==1){
    suretxt.setText(""+Level5.sayıcıs);
}else if (Kolay.Bu==1){
            suretxt.setText(""+Kolay.sayıcıs);
sure=Kolay.sayıcıs;
        }else if (Normal.Bu==1){
    suretxt.setText(""+Normal.sayıcıs);
    sure = Normal.sayıcıs;
} else if (Zor.Bu==1){
    suretxt.setText(""+Zor.sayıcıs);
    sure=Zor.sayıcıs;
}

    }
}
