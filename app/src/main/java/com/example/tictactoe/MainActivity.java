package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //array list btn
    ArrayList<Button> btns = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn00 = findViewById(R.id.btn_0);
        Button btn01 = findViewById(R.id.btn_1);
        Button btn02 = findViewById(R.id.btn_2);
        Button btn03 = findViewById(R.id.btn_3);
        Button btn04 = findViewById(R.id.btn_4);
        Button btn05 = findViewById(R.id.btn_5);
        Button btn06 = findViewById(R.id.btn_6);
        Button btn07 = findViewById(R.id.btn_7);
        Button btn08 = findViewById(R.id.btn_8);

        btns.add(btn00);
        btns.add(btn01);
        btns.add(btn02);
        btns.add(btn03);
        btns.add(btn04);
        btns.add(btn05);
        btns.add(btn06);
        btns.add(btn07);
        btns.add(btn08);
    }//end onCreate method

    public void onClickbtn00(View view)
    {
        tableBtnCLicked(0);
    }//end on btn 00 clicked
    public void onClickbtn01(View view)
    {
        tableBtnCLicked(1);
    }//end on btn 01 clicked
    public void onClickbtn02(View view)
    {
        tableBtnCLicked(2);
    }//end on btn 02 clicked
    public void onClickbtn03(View view)
    {
        tableBtnCLicked(3);
    }//end on btn 03 clicked
    public void onClickbtn04(View view)
    {
        tableBtnCLicked(4);
    }//end on btn 04 clicked
    public void onClickbtn05(View view)
    {
        tableBtnCLicked(5);
    }//end on btn 05 clicked
    public void onClickbtn06(View view)
    {
        tableBtnCLicked(6);
    }//end on btn 06 clicked
    public void onClickbtn07(View view)
    {
        tableBtnCLicked(7);
    }//end on btn 07 clicked
    public void onClickbtn08(View view)
    {
        tableBtnCLicked(8);
    }//end on btn 08 clicked
    public void onClickReset(View view)
    {
        //just testing that it works
        Log.i("Test", "---------You clicked the reset button-------------");
    }//end resetOnClick

    //theoretically we should be doing the same thing for every btn in the table
    //To access the array list of btns, we simply check which button was pressed,
    //then do whatever we want to do with each of the buttons
    //this saves time copying and individualizing what we want done with each button
    public void tableBtnCLicked(int btn)
    {
        //for example
        for (int i = 0; i < btns.size(); i++)
        {
            if(i == btn)
            {
                //not the actual algorithm, just a quick example
                btns.get(i).setText("X");
            }
        }
    }

}//end MainActivity