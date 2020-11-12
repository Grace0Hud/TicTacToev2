package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    

}//end MainActivity