package com.rad.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
boolean gameActive=true;
    //player representation
    //0-X
    //1-O

    int activePlayer= 0;
    int[] gameState ={ 2, 2, 2, 2, 2, 2, 2, 2, 2};

    // Statement meaning
    // 0 - X
    // 1 - O
    // 2 - NULL
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                           {0,3,6}, {1,4,7}, {2,5,8},
                           {0,4,8}, {2,4,6}};

    @SuppressLint("SetTextI18n")
    public void playerTap(View view){

        ImageView img=(ImageView)view;   //used to display an image file in application
        int tappedImage = Integer.parseInt(img.getTag().toString()); // converts its first argument to a string, parses that string, then returns an integer
        if(!gameActive){
            gameReset(view);

        }
        if(gameState[tappedImage]==2){

          gameState[tappedImage]= activePlayer;
            img.setTranslationY(-1000f);

            if(activePlayer == 0){                                      // if ntg is blank then put 1 (x) else 0(o)
                img.setImageResource(R.drawable.xxxpng);               //inserts thr png image of x
                activePlayer=1;
                TextView status = findViewById(R.id.STATUS);
                status.setText("O's turn please tap to play");
            }
            else {
                img.setImageResource(R.drawable.ooopng);                //inserts thr png image of o
                activePlayer = 0;
                TextView status = findViewById(R.id.STATUS);
                status.setText("X's turn please tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        // check if anyone won
        for(int[] winPosition : winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]]&&
                    gameState[winPosition[1]]==gameState[winPosition[2]]&&gameState[winPosition[0]]!=2){
//somebody has won find put who?
                String winnerStr;
                gameActive=false;
                if(gameState[winPosition[0]]==0){
                    winnerStr="X has won the game";

                }
                else {
                    winnerStr="O has won the game";
                }
                //update thr status bar(txt view below) for winner
                TextView status = findViewById(R.id.STATUS);
                status.setText(winnerStr);
            }

        }



        }


    public void gameReset(View view){
        gameActive=true;
        activePlayer =0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        TextView status = findViewById(R.id.STATUS);
        status.setText("X's turn please tap to play");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}