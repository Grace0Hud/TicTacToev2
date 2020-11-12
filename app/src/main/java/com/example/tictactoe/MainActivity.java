package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button resetGame;
    //array list btn
    private Button[] btns = new Button[9];
    private int playerOneScoreCount, playerTwoScoreCount, rountCount;
    boolean activePlayer;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {
            {0, 1, 2}, {3, 4, 5,}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore = (TextView) findViewById(R.id.playerOneScore);
        playerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
        playerStatus = (TextView) findViewById(R.id.playerStatus);

        resetGame = (Button) findViewById(R.id.resetGame);

        for (int i = 0; i < btns.length; i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            btns[i] = (Button) findViewById(resourceID);
            btns[i].setOnClickListener(this);
        }

        rountCount = 0;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        activePlayer = true;

//        Button btn00 = findViewById(R.id.btn_0);
//        Button btn01 = findViewById(R.id.btn_1);
//        Button btn02 = findViewById(R.id.btn_2);
//        Button btn03 = findViewById(R.id.btn_3);
//        Button btn04 = findViewById(R.id.btn_4);
//        Button btn05 = findViewById(R.id.btn_5);
//        Button btn06 = findViewById(R.id.btn_6);
//        Button btn07 = findViewById(R.id.btn_7);
//        Button btn08 = findViewById(R.id.btn_8);
//
//        btns.add(btn00);
//        btns.add(btn01);
//        btns.add(btn02);
//        btns.add(btn03);
//        btns.add(btn04);
//        btns.add(btn05);
//        btns.add(btn06);
//        btns.add(btn07);
//        btns.add(btn08);
//    }//end onCreate method
//


        //theoretically we should be doing the same thing for every btn in the table
        //To access the array list of btns, we simply check which button was pressed,
        //then do whatever we want to do with each of the buttons
        //this saves time copying and individualizing what we want done with each button
//    public void tableBtnCLicked(int btn)
//    {
//        //for example
//        for (int i = 0; i < btns.size(); i++)
//        {
//            if(i == btn)
//            {
//                //not the actual algorithm, just a quick example
//                btns.get(i).setText("X");
//            }
//        }
//    }

    }//end MainActivity

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        String buttonID = view.getResources().getResourceEntryName(view.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length()));

        if (activePlayer){
            ((Button) view).setText("X");
        ((Button) view).setTextColor(Color.parseColor("#465362"));
        gameState[gameStatePointer] = 0;
    } else {
            ((Button)view).setText("O");
            ((Button)view).setTextColor(Color.parseColor("#82A3A1"));
            gameState[gameStatePointer] = 1;
        }
        rountCount++;

        if(checkWinner())
        {
            if(activePlayer)
            {
                playerOneScoreCount++;
                updatePlayerScore();
            } else {
                playerTwoScoreCount++;
                updatePlayerScore();
            }
        } else if (rountCount==9)
        {
            //put play again in here
        } else {
            activePlayer = !activePlayer;
        }

    }
    public boolean checkWinner()
    {
        boolean winnerResult = false;
        for(int [] winningPosition : winningPositions)
        {
            if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2)
            {
                winnerResult = true;
            }
        }
        return winnerResult;
    }

    public void updatePlayerScore()
    {
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }


}
