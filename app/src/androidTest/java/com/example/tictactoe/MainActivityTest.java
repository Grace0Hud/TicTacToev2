package com.example.tictactoe;


import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest extends TestCase {

    @Test
    public void playerOneCountGetnSet()
    {
        MainActivity.setPlayerOneScoreCount(4);
       int expected = 4;
       assertEquals(expected,  MainActivity.getPlayerOneScoreCount());
    }
    @Test
    public void playerTwoCountGetnSet()
    {
        MainActivity.setPlayerTwoScoreCount(4);
        int expected = 4;
        assertEquals(expected, MainActivity.getPlayerTwoScoreCount());
    }

    @Test
    public void resetPlayerOneScore()
    {
       MainActivity.setPlayerOneScoreCount(4);
       int expected = 0;
       MainActivity.reset();
       assertEquals(expected, MainActivity.getPlayerOneScoreCount());
    }

    @Test
    public void resetPlayerTwoScore()
    {
        MainActivity.setPlayerTwoScoreCount(4);
        int expected = 0;
        MainActivity.reset();
        assertEquals(expected, MainActivity.getPlayerTwoScoreCount());
    }

    @Test
    public void updatePlayerOneScore()
    {
        MainActivity.setPlayerOneScoreCount(1);
        int expected = 1;
        MainActivity.getPlayerOneScoreCount();
        assertEquals(expected, MainActivity.getPlayerOneScoreCount());
    }

    @Test
    public void updatePlayerTwoScore()
    {
        MainActivity.setPlayerTwoScoreCount(1);
        int expected = 1;
        MainActivity.getPlayerTwoScoreCount();
        assertEquals(expected, MainActivity.getPlayerTwoScoreCount());
    }
}