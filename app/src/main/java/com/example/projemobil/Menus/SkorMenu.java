package com.example.projemobil.Menus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.projemobil.Db.DB_Katmani;
import com.example.projemobil.R;
import android.database.Cursor;
import android.widget.TextView;

public class SkorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_menu);
    ViewAll();




    }
    public void ViewAll(){
        Cursor res = Anamenu.mdb.getAllData();
        if(res.getCount()==0){

showMassage("Error", "Kayıtlı veri yok");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append(res.getString(0)+"\t\t\t\t\t\t\t\t\t\t");
            buffer.append(res.getInt(1)+"\n");
        }
        showMassage("HighScores", buffer.toString());
    }
    public void showMassage(String title , String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();

    }


    @Override
    public void onBackPressed() {

        Intent i = new Intent(getApplicationContext(),Anamenu.class);
        startActivity(i);
    }
}
