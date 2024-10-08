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
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import com.example.androidexample.gamelogic.Card;
import com.example.androidexample.gamelogic.Game;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity{

    private Game game;
    private PlayAreaFragment playAreaFragment;
    private SidebarFragment sidebarFragment;
    private FragmentContainerView playFragmentContainer;
    private FragmentContainerView sidebarFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        this.sidebarFragment = (SidebarFragment) getSupportFragmentManager().getFragments().get(0);
        this.playAreaFragment = (PlayAreaFragment) getSupportFragmentManager().getFragments().get(1);

        game = new Game(playAreaFragment, sidebarFragment);
    }

    public Game getGame() {
        return game;
    }
}
