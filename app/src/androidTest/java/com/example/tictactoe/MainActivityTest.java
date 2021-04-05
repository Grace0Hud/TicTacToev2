package com.example.tictactoe;

import android.os.Looper;

import junit.framework.TestCase;

public class MainActivityTest extends TestCase {

    public void testOnCreate()
    {

    }

    public void testResetScores()//had to comment out playAgain() function inside
    {
        Looper.prepare();
        MainActivity reset = new MainActivity();
        reset.setPlayerOneScoreCount(4);
        reset.resetScores();
        String equals = "0";
        assertEquals(equals, reset.getPlayerOneScoreCount());

    }

    public void testOnClick()
    {
    }

    public void testCheckWinner()
    {
    }

    public void testUpdatePlayerScore()
    {
    }

    public void testChangeScreen()
    {
    }

    public void testPlayAgain()
    {
    }


}