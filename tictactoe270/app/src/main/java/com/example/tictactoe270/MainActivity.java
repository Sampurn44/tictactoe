package com.example.tictactoe270;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClick=-1;
    int player=1; //player 1 is cross
    int [][]winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load(View view){

        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imageClick=gamestate[tag];
        if(!isWinner && imageClick==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.pinclipart_com_closing_clip_art_992857__1_);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable._2518786_141845487620_2);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int[] ints : winning) {

                if (gamestate[ints[0]] == gamestate[ints[1]] && gamestate[ints[1]] == gamestate[ints[2]] && gamestate[ints[0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner = true;
                }

            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridlayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v = (ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        player=1;
        isWinner=false;
        imageClick=-1;
        Arrays.fill(gamestate, -1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}