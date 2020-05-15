package com.example.projemobil.Hızlı;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projemobil.oyunYonet;
import com.example.projemobil.Klasik.Kolay;
import com.example.projemobil.Klasik.Normal;
import com.example.projemobil.Klasik.Zor;
import com.example.projemobil.Menus.HizliMenu;
import com.example.projemobil.Menus.LoseMenu;
import com.example.projemobil.R;

import java.util.Timer;
import java.util.TimerTask;
public class Level1 extends AppCompatActivity {
    public static   int sayıcı=0,sayıcıs=30;
    public static Button smileybtn;
    TextView sayıcıtxt,zamantxt;
    private Timer mTimer;
    public static int Bu;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        sayıcıtxt=findViewById(R.id.sayıcıtxt);
        zamantxt=findViewById(R.id.zamantxt);
        smileybtn=findViewById(R.id.smileybtn);
        Bu=1;
        Level2.Bu=0;
        Level3.Bu=0;
        Level4.Bu=0;
        Level5.Bu=0;
        Kolay.Bu=0;
        Normal.Bu=0;
        Zor.Bu=0;
        smileybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayıcıs=30;
                sayıcı=0;
                stopTimer();
                finish();
                startActivity(getIntent());
            }
        });
        startTimer();



        oyunYonet.getInstance().gridiOlustur(this);

    }


    void startTimer() {


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        sayıcıs--;
                        sayıcıtxt.setText(""+sayıcı);
                        zamantxt.setText(""+sayıcıs);
                        if (sayıcıs==0){
                            stopTimer();
                            sayıcıs=30;
                            sayıcı=0;
                            Intent i = new Intent(getApplicationContext(), LoseMenu.class);
                            startActivity(i);
                        }



                    }
                });
            }
        };

        mTimer = new Timer();

        // Delay: 0, Interval: 1000ms
        mTimer.schedule(timerTask, 0, 1000);
    }
    void stopTimer() {


        mTimer.cancel();
        mTimer = null;
    }

    @Override
    public void onBackPressed() {
        stopTimer();
        sayıcıs=0;
        sayıcı=0;
        Intent i = new Intent(getApplicationContext(), HizliMenu.class);
        startActivity(i);
    }
}
