package com.example.projemobil.Layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.projemobil.oyunYonet;
import com.example.projemobil.Hızlı.Level1;
import com.example.projemobil.Hızlı.Level2;
import com.example.projemobil.Hızlı.Level3;
import com.example.projemobil.Hızlı.Level4;
import com.example.projemobil.Hızlı.Level5;
import com.example.projemobil.Klasik.Kolay;
import com.example.projemobil.Klasik.Normal;
import com.example.projemobil.Klasik.Zor;
import com.example.projemobil.R;


public class Cell extends BaseCell implements View.OnClickListener , View.OnLongClickListener{
private int width= oyunYonet.WIDTH;
private int height= oyunYonet.HEIGHT;
    public Cell( Context context , int x , int y ){
        super(context);

        setPosition(x,y);

        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public void onClick(View v) {
        if(isClicked()==false && isFlagged()==false)
        oyunYonet.getInstance().tikla( getXPos(), getYPos() );

    }

    @Override
    public boolean onLongClick(View v) {
        if(isClicked()==false && isFlagged()==false){
        oyunYonet.getInstance().bayrak( getXPos() , getYPos() );
            if (Level1.Bu==1){
                Level1.sayıcı++;
            }else if (Level2.Bu==1){
                Level2.sayıcı++;
            } else if (Level3.Bu==1){
                Level3.sayıcı++;
            } else if (Level4.Bu==1){
                Level4.sayıcı++;
            }else if (Level5.Bu==1){
                Level5.sayıcı++;
            }else if (Kolay.Bu==1){
                Kolay.sayıcı++;
            }else if (Normal.Bu==1){
                Normal.sayıcı++;
            } else if (Zor.Bu==1){
                Zor.sayıcı++;
            }}else
        if(isFlagged()==true){
            oyunYonet.getInstance().bayrak( getXPos() , getYPos() );
            if (Level1.Bu==1){
                Level1.sayıcı--;
            }else if (Level2.Bu==1){
                Level2.sayıcı--;
            } else if (Level3.Bu==1){
                Level3.sayıcı--;
            } else if (Level4.Bu==1){
                Level4.sayıcı--;
            }else if (Level5.Bu==1){
                Level5.sayıcı--;
            }else if (Kolay.Bu==1){
                Kolay.sayıcı--;
            }else if (Normal.Bu==1){
                Normal.sayıcı--;
            } else if (Zor.Bu==1){
                Zor.sayıcı--;
            }}
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        cizButon(canvas);

        if( isFlagged() ){
            cizBayrak(canvas);
        }else if( isRevealed() && isBomb() && !isClicked() ){
            cizBomba(canvas);
        }else {
            if( isClicked() ){
                if( getValue() == -1 ){
                    cizPatlayanBomba(canvas);
                }else {
                    cizSayi(canvas);
                }
            }else{
                cizButon(canvas);
            }
        }
    }

    private void cizPatlayanBomba(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_exploded);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void cizBayrak(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.flag);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void cizButon(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void cizBomba(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_normal);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void cizSayi(Canvas canvas ){
        Drawable drawable = null;

        switch (getValue() ){
            case 0:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_0);
                break;
            case 1:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_1);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_2);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_3);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_4);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_5);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_6);
                break;
            case 7:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_7);
                break;
            case 8:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_8);
                break;
        }

        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }


}