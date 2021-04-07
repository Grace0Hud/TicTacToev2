package com.example.tictactoe;

import junit.framework.TestCase;
import junit.framework.TestResult;

import static org.junit.Assert.assertArrayEquals;

public class MainActivityTest extends TestCase {

    public void testCheckWinner()
    {
        /*
        MainActivity test = new MainActivity();
        int[][] board = {{0,0,0},{0,2,2},{0,1,1}};
        //array after move {0,0,0},{0,2,2},{1,1,1}
        assertArrayEquals(new int[] {2,0},test.checkWinner(board));
        */

        /*
        MainActivity test = new MainActivity();
        int[][] board = {{0,1,0},{1,1,2},{0,2,2}};
        //arr   ay after move {0,1,1},{1,1,2},{0,2,2}
        //available spaces: {0,0} {0,2} {2,0}
        assertArrayEquals(new int[] {0,0},test.checkWinner(board)); // or {2,0}
        */
    }

    public void testUpdatePlayerScore()
    {

    }

    public void testChangeScreen() {
    }

    public void testPlayAgain() {
        /*
        MainActivity tests = new MainActivity();
        tests.resetScores("0");
        String expected = "0";
        assertEquals(expected, MainActivity.resetScores());
        */
    }

    public void testResetScores()
    {
        /*
        MainActivity tests = new MainActivity();
        tests.resetScores("0");
        String expected = "0";
        assertEquals(expected, MainActivity.resetScores());
        */

        MainActivity test = new MainActivity();
        // Check a positive
        System.out.println(test.updatePlayerScore());
        // Check a negative
        System.out.println(test.updatePlayerScore());
        // Check a positive
        System.out.println(test.updatePlayerScore());
    }
}