package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private Button singlePLayerButton;
    private Button multiPlayerButton;
    private Button infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        singlePLayerButton = (Button) findViewById(R.id.singlePlayerButton);
        singlePLayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMainActivty();
            }
        });

        multiPlayerButton = (Button) findViewById(R.id.multiPlayerButton);
        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwoPlayerMainAct();
            }
        });

        infoButton = (Button) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfoActivity();
            }
        });
    }

    public void openMainActivty() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("singlePlayer", true);
        startActivity(intent);
    }
    public void openTwoPlayerMainAct() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("singlePlayer", false);
        startActivity(intent);
    }

    public void openInfoActivity() {
        Intent intent2 = new Intent(this, InfoActivity.class);
        startActivity(intent2);
    }
}