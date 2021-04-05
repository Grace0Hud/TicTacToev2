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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button resetGame;
    //array list btn
    private Button[] btns = new Button[9];
    private int playerOneScoreCount, playerTwoScoreCount, roundCount, togetherTeam, placement;
    boolean activePlayer, cpu;//true = x; false = o
    static boolean singlePlayer;


    int[] board = {2, 2, 2, 2, 2, 2, 2, 2, 2}; //makes the board set; 0 for player one & 1 for player two

    int[][] winningPositions = { //shows all winning positions on the grid
            {0, 1, 2}, {3, 4, 5,}, {6, 7, 8}, //rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //columns
            {0, 4, 8}, {2, 4, 6} //diagonal
    };
    int winningScore = 1 ;  //score needed for a player to win (should be changed later, it is set to 1 as a test case)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore = (TextView) findViewById(R.id.playerOneScore);
        playerTwoScore = (TextView) findViewById(R.id.playerTwoScore);
        playerStatus = (TextView) findViewById(R.id.playerStatus);
        togetherTeam = 2;

        resetGame = (Button) findViewById(R.id.resetGame);

        for (int i = 0; i < btns.length; i++)
        {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());//turns previous String into a R.id.
            btns[i] = (Button) findViewById(resourceID);
            btns[i].setOnClickListener(this);
        }

        roundCount = 0;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        activePlayer = true; //changes on which player is going
        singlePlayer = getIntent().getBooleanExtra("singlePlayer", false);

//        if(singlePlayer)
//        {
////            //randomizing cpu
////            double ran =  Math.random() * 10;
////            if(ran < 5)
////            {
////                cpu = true; // cpu = x
////            }
////            else
////                cpu = false; //cpu = o
//            if (activePlayer) {
//                if (cpu) {
//                    btns[placeCpu()].setText("X");
//
//                }
//
//            }
//            else if(!activePlayer)
//            {
//                if(!cpu)
//                {
//                    btns[placeCpu()].setText("X");
//                }
//            }
//        }

        /*
          if(checkWinner())
        {
            if(activePlayer)
            {
                playerOneScoreCount++;
                updatePlayerScore();
                changeScreen("Player 1 WINS!!");
            }//end if  player 1's turn
            else {
                playerTwoScoreCount++;
                updatePlayerScore();
                changeScreen("Player 2 WINS!!");
            }//end else (player 2's turn)
        } else if (roundCount==9) //checks if it results in a tie
        {
            changeScreen("TIE :(");
        } else
        {
            activePlayer = !activePlayer;
            if(activePlayer)
            {
                playerOneDisplay.setTextColor(getResources().getColor(R.color.ivory));
                playerTwoDisplay.setTextColor(getResources().getColor(R.color.tangerine));
            }
            else
            {
                playerTwoDisplay.setTextColor(getResources().getColor(R.color.ivory));
                playerOneDisplay.setTextColor(getResources().getColor(R.color.tangerine));
            }
        }
         */

    }//end MainActivity

    public void onClickReset(View view)
    {
        resetScores();
    }//end reset on click listener
    @Override
    public void onClick(View view) {

        if (!((Button) view).getText().toString().equals("")) {//checks to make sure you are clicking an empty box
            return;
        }
        String buttonID = view.getResources().getResourceEntryName(view.getId()); //gets the id for a button clicked
        int boardPointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1)); //gets rid of the button from the grid once clicked

        if (activePlayer){
            ((Button) view).setText("X"); //adds an x to the button
        ((Button) view).setTextColor(getResources().getColor(R.color.blueYonder)); //changes the color of the x added to button
            board[boardPointer] = 0; //updates which buttons are still on the board & 0 for player one


    } else {
            ((Button)view).setText("O"); //adds an o to the button
            ((Button)view).setTextColor(getResources().getColor(R.color.ivory));//changes the color of the o added to the button

            board[boardPointer] = 1; //updates which buttons are on the board & 1 for player two
        }
        roundCount++; //increases for check of tie

        TextView playerOneDisplay = (TextView)findViewById(R.id.playerOne);
        TextView playerTwoDisplay = (TextView)findViewById(R.id.playerTwo);
        if(activePlayer)
        {
            winOrSwitch(playerOneDisplay, playerTwoDisplay,  1);
        }
        else
        {
            winOrSwitch(playerTwoDisplay, playerOneDisplay,  2);
        }



    }//end on click
    //getters and setters for testing
    public static void setSinglePlayer(Boolean single) //can be tested once testing is figures out
    {
        singlePlayer = single;
        System.out.println("single bool is" + singlePlayer);
    }


    public int getPlayerOneScoreCount() {
        return playerOneScoreCount;
    }

    public void setPlayerOneScoreCount(int playerOneScoreCount) {
        this.playerOneScoreCount = playerOneScoreCount;
    }
    public void setTogetherTeam(int togetherTeam) {
        this.togetherTeam = togetherTeam;
    }
    public int getTogetherTeam()
    {
        return togetherTeam;
    }

    public int getPlayerTwoScoreCount() {
        return playerTwoScoreCount;
    }

    public void setPlayerTwoScoreCount(int playerTwoScoreCount) {
        this.playerTwoScoreCount = playerTwoScoreCount;
    }

    public void winOrSwitch(TextView display, TextView otherDisplay, int player)
    {
        //checks if someone has won, then updates
        if(checkWinner())
        {
            if(player == 1)
            {
                playerOneScoreCount++;
            }
            else
            {
                playerTwoScoreCount++;
            }
            updatePlayerScore();
            changeScreen("Player " + player + " WINS!");
        } else if (roundCount==9) //checks if it results in a tie
        {
            changeScreen("TIE :(");
        } else
        {
            //switches which player + color display

                activePlayer = !activePlayer;
                if(singlePlayer && activePlayer == false)
                {
                    placeCpu();
                }
                display.setTextColor(getResources().getColor(R.color.ivory));
                otherDisplay.setTextColor(getResources().getColor(R.color.tangerine));
        }
    }
    public boolean checkWinner()
    {
        boolean winnerResult = false; //autosets the winner to false
        if (checkSpotsTogether() == 3)
        {
            winnerResult = true;
        }
        return winnerResult;//returns the boolean
    }
    //checking how many spaces are equal to one player
    public int checkSpotsTogether()
    {
        int spaces = 0;
        for(int[] winningPosition : winningPositions)
        {

            if(board[winningPosition[0]] == board[winningPosition[1]] && board[winningPosition[0]] != 2)
            {

                if(board[winningPosition[0]] == board[winningPosition[1]] &&
                        board[winningPosition[1]] == board[winningPosition[2]] &&
                        board[winningPosition[0]] != 2)
                {
                   spaces = 3;
                }
                else {
                    if (board[winningPosition[0]] == 1) {
                        setTogetherTeam(1);
                    }
                    else {
                        setTogetherTeam(0);
                    }
                    spaces = 2;
                    placement = winningPosition[2];
                }
            }

        }
        return spaces;
    }

    public int getPlacement()
    {
        return placement;
    }

    public void updatePlayerScore()
    {
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void changeScreen(String str)//changes screen after player wins
    {
        //opens up a dialogue box instead of a layout for the win screen
        LayoutInflater layoutInflater = LayoutInflater.from(this);

        View promptView = layoutInflater.inflate(R.layout.activity_win_screen, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        //set up reference for winnerTV so that Jaque can do updates - thanks :)
        alertDialogBuilder.setView(promptView);
        TextView winnerTv = (TextView) promptView.findViewById(R.id.winnerTV);
         winnerTv.setText(str);

        // set prompts.xml to be the layout file of the alertdialog builder
        alertDialogBuilder.setView(promptView);

        // setup a dialog window
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playAgain();
                     //dialog.cancel();
                    }
                })
                .setNegativeButton("Reset Scores",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                resetScores();
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alertD = alertDialogBuilder.create();

        alertD.show();
    }

    public void playAgain()
    {
        for(int i = 0; i < btns.length; i++)
        {
            btns[i].setText("");
            board[i] = 2;
        }//end for
        roundCount = 0;
    }//end playAgain

    public void resetScores()
    {
        //playAgain();
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        updatePlayerScore();
        playAgain();
    }//end reset scores
    //place cpu method, to  attempt to figure out the best placement to win against opponent
    public void placeCpu()
    {
        boolean placed = false;
        int place = (int)(Math.random()*10 - 1);
        while(!placed)
        {
            if(board[place] == 2)
            {
                btns[place].performClick();
               // board[place] = 1;
                placed = true;
            }
            else
            {
                place = (int)(Math.random()*10 - 1);
            }
        }

//        int place = -1;
//        int together = checkSpotsTogether();
//        int avalible[] = {9};
//        int count = 0;
//        boolean stop = false;
//        if(together == 2 && togetherTeam == 0 && !cpu) {
//            place = getPlacement();
//        }
//        else
//        {
//            for(int i = 0; i < board.length; i++)
//            {
//                if(board[i] == 2)
//                {
//                    avalible[count] = board[i];
//                    count++;
//                }
//            }
//            count = 0;
//            while(!stop)
//            {
//                place = board[count];
//                count++;
//                if(Math.random()*10 > 7 && board[count] != 0)
//                {
//                    stop = true;
//                }
//            }
//        }
//        activePlayer = false;
//        btns[place].performClick();
  }



}
