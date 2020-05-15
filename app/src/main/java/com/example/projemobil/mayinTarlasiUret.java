package com.example.projemobil;

import java.util.Random;


public class mayinTarlasiUret {


    public static int[][] uret(int bombnumber , final int width , final int height){

        Random r = new Random();

        int [][] grid = new int[width][height];
        for( int x = 0 ; x< width ;x++ ){
            grid[x] = new int[height];
        }

        while( bombnumber > 0 ){
            int x = r.nextInt(width);
            int y = r.nextInt(height);


            if( grid[x][y] != -1 ){
                grid[x][y] = -1;
                bombnumber--;
            }
        }
        grid = komsuHesapla(grid,width,height);

        return grid;
    }

    private static int[][] komsuHesapla(int[][] grid , final int width , final int height){
        for( int x = 0 ; x < width ; x++){
            for( int y = 0 ; y < height ; y++){
                grid[x][y] = komsuSayisiniAl(grid,x,y,width,height);
            }
        }

        return grid;
    }

    private static int komsuSayisiniAl(final int grid[][] , final int x , final int y , final int width , final int height){
        if( grid[x][y] == -1 ){
            return -1;
        }

        int count = 0;

        if( bombaVarmı(grid,x - 1 ,y + 1,width,height)) count++; // sol üst
        if( bombaVarmı(grid,x     ,y + 1,width,height)) count++; // üst
        if( bombaVarmı(grid,x + 1 ,y + 1,width,height)) count++; // sağ üst
        if( bombaVarmı(grid,x - 1 ,y    ,width,height)) count++; // sol
        if( bombaVarmı(grid,x + 1 ,y    ,width,height)) count++; // sağ
        if( bombaVarmı(grid,x - 1 ,y - 1,width,height)) count++; // sol alt
        if( bombaVarmı(grid,x     ,y - 1,width,height)) count++; // alt
        if( bombaVarmı(grid,x + 1 ,y - 1,width,height)) count++; // sag alt

        return count;
    }

    private static boolean bombaVarmı(final int [][] grid, final int x , final int y , final int width , final int height){
        if( x >= 0 && y >= 0 && x < width && y < height ){
            if( grid[x][y] == -1 ){
                return true;
            }
        }
        return false;
    }

}