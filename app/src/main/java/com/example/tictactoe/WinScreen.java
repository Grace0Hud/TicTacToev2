package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);
    }

    public void onClickPlayAgainBtn(View view)
    {
        //not yet able to test as we do not yet have a way to navigate between screens
        Log.i("Test", "-----You clicked the play again btn------");
        finish();
    }//end playagain onCLick
}