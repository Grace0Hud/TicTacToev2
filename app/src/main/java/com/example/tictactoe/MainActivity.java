package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button resetGame;
    //array list btn
    private Button[] btns = new Button[9];
    private int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;

    int[] board = {2, 2, 2, 2, 2, 2, 2, 2, 2}; //makes the board set

    int[][] winningPositions = { //shows all winning positions on the grid
            {0, 1, 2}, {3, 4, 5,}, {6, 7, 8}, //rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //columns
            {0, 4, 8}, {2, 4, 6} //diagonal
    };
    int winningScore=1; //score needed for a player to win (should be changed later, it is set to 1 as a test case)
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
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());//turns previous String into a R.id.
            btns[i] = (Button) findViewById(resourceID);
            btns[i].setOnClickListener(this);
        }

        roundCount = 0;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        activePlayer = true; //changes on which player is going

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
        if (!((Button) view).getText().toString().equals("")) {//checks to make sure you are clicking an empty box
            return;
        }
        String buttonID = view.getResources().getResourceEntryName(view.getId()); //gets the id for a button clicked
        int boardPointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length())); //gets rid of the button from the grid once clicked

        if (activePlayer){
            ((Button) view).setText("X"); //adds an x to the button
        ((Button) view).setTextColor(Color.parseColor("#465362")); //changes the color of the x added to button
            board[boardPointer] = 0; //updates which buttons are still on the board & 0 for player one
    } else {
            ((Button)view).setText("O"); //adds an o to the button
            ((Button)view).setTextColor(Color.parseColor("#82A3A1"));//changes the color of the o added to the button
            board[boardPointer] = 1; //updates which buttons are on the board & 1 for player two
        }
        roundCount++; //increases for check of tie

        if(checkWinner())
        {
            if(activePlayer)
            {
                playerOneScoreCount++;
                updatePlayerScore();
                //buttons need to be reset until ↓ is true
                if(playerOneScoreCount==winningScore)//checks to see is player 1 has reached the required score to win
                {
                    changeScreen();
                }//end inner if
            }//end if  player 1's turn
            else {
                playerTwoScoreCount++;
                updatePlayerScore();
                if(playerTwoScoreCount==winningScore)//checks to see is player 2 has reached the required score to win
                {
                    changeScreen();
                }   //end inner if
            }//end else (player 2's turn)
        } else if (roundCount==9) //checks if it results in a tie
        {
            //put play again in here
        } else {
            activePlayer = !activePlayer;
        }

    }
    public boolean checkWinner()
    {
        boolean winnerResult = false; //autosets the winner to false
        for(int [] winningPosition : winningPositions)
        {

            if(board[winningPosition[0]] == board[winningPosition[1]] &&
                    board[winningPosition[1]] == board[winningPosition[2]] &&
                    board[winningPosition[0]] != 2) //goes through and checks after each button is pressed if any of the conditions met in winning positions are true
            {
                winnerResult = true; //if the conditions are met, then it sets the winner to true
            }
        }
        return winnerResult;//returns the boolean
    }

    public void updatePlayerScore()
    {
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void changeScreen()//changes score after player wins
    {
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        View promptView = layoutInflater.inflate(R.layout.activity_win_screen, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set prompts.xml to be the layout file of the alertdialog builder
        alertDialogBuilder.setView(promptView);

        // setup a dialog window
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                     dialog.cancel();
                    }
                })
                .setNegativeButton("Return",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alertD = alertDialogBuilder.create();

        alertD.show();
    }

}
