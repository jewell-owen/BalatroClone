package com.example.androidexample;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.androidexample.gamelogic.Card;
import com.example.androidexample.gamelogic.Game;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity{

    private Game game;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



    }


    public void setGame(Game game){
        this.game = game;
    }


    public Game getGame() {
        return game;
    }
}
