package com.example.tictactoe;

import android.os.Looper;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

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


}