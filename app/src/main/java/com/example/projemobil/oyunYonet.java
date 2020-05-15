package com.example.projemobil;

import android.content.Context;
import android.content.Intent;

import com.example.projemobil.Layout.Cell;
import com.example.projemobil.Menus.HizliMenu;
import com.example.projemobil.Menus.KlasikMenu;
import com.example.projemobil.Menus.LoseMenu;
import com.example.projemobil.Menus.WinMenu;


public class oyunYonet {
    private static oyunYonet instance;
    public  static int BOMB_NUMBER ;
    public static int WIDTH ;
    public static int HEIGHT ;
    public static int kazandiMi;
    private Context context;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];

    public static oyunYonet getInstance() {
        if( instance == null ){
            instance = new oyunYonet();
        }
        return instance;
    }

    private oyunYonet(){ }

    public void gridiOlustur(Context context){

        this.context = context;
if(KlasikMenu.mod=="klasik"){//klasik moddaki degerleri al

        BOMB_NUMBER=KlasikMenu.bomba;
        WIDTH=KlasikMenu.genislik;
        HEIGHT=KlasikMenu.uzunluk;}
 else if (HizliMenu.mod=="hizli"){//hızlı moddaki degerleri al

      BOMB_NUMBER=HizliMenu.bomba;
    WIDTH=HizliMenu.genislik;
    HEIGHT=HizliMenu.uzunluk;

}
 kazandiMi=0;
 MinesweeperGrid = new Cell[WIDTH][HEIGHT];//Gridi oluştur

        int[][] GeneratedGrid = mayinTarlasiUret.uret(BOMB_NUMBER,WIDTH, HEIGHT);

        ayarlaGrid(context,GeneratedGrid);
    }

    private void ayarlaGrid(final Context context, final int[][] grid ){//gridi ayarla
        for( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( MinesweeperGrid[x][y] == null ){
                    MinesweeperGrid[x][y] = new Cell( context , x,y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }
    }

    public Cell hucrePozisyon(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;

        return MinesweeperGrid[x][y];
    }

    public Cell hucrePozisyon(int x , int y ){
        return MinesweeperGrid[x][y];
    }

    public void tikla(int x , int y ){
        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT && !hucrePozisyon(x,y).isClicked() ){
            hucrePozisyon(x,y).setClicked();

            if( hucrePozisyon(x,y).getValue() == 0 ){
                for( int xt = -1 ; xt <= 1 ; xt++ ){
                    for( int yt = -1 ; yt <= 1 ; yt++){
                        if( xt != yt ){
                            tikla(x + xt , y + yt);
                        }
                    }
                }
            }

            if( hucrePozisyon(x,y).isBomb() ){
                gameOver();
            }
        }

        bittiMi();
    }

    private boolean bittiMi(){
        int bombNotFound = BOMB_NUMBER;
        int notRevealed = WIDTH * HEIGHT;
        for ( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( hucrePozisyon(x,y).isRevealed() || hucrePozisyon(x,y).isFlagged() ){
                    notRevealed--;
                }

                if( hucrePozisyon(x,y).isFlagged() && hucrePozisyon(x,y).isBomb() ){
                    bombNotFound--;
                }
            }
        }

        if( bombNotFound == 0 && notRevealed == 0 ){
            kazandiMi=1;

            Intent i = new Intent(context , WinMenu.class);//Win Menu ye git

            context.startActivity(i);

        }
        return false;
    }

    public void bayrak(int x , int y ){
        boolean isFlagged = hucrePozisyon(x,y).isFlagged();
        hucrePozisyon(x,y).setFlagged(!isFlagged);
        hucrePozisyon(x,y).invalidate();


    }

    private void gameOver(){



        for ( int x = 0 ; x < WIDTH ; x++ ) {
            for (int y = 0; y < HEIGHT; y++) {
                hucrePozisyon(x,y).setRevealed();
            }
        }

        Intent i= new Intent(context, LoseMenu.class);//LoseMenu ye git
        context.startActivity(i);

    }

}