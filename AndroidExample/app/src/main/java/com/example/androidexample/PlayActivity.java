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
    private LinearLayout handLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        handLinearLayout = findViewById(R.id.play_hand_linearlayout);

        game = new Game();
        createCards(game.getHand());

    }

    private void createCards(ArrayList<Card> hand) {
        // Create a new CardView for each card
        for (Card card : hand) {
            CardView cardView = createCardView();

            // Add the CardView to the LinearLayout (inside the HorizontalScrollView)
            handLinearLayout.addView(cardView);
        }

    }


    private CardView createCardView()  {
        // Inflate the CardView layout
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        CardView cardView = (CardView) inflater.inflate(R.layout.card_king_diamonds, handLinearLayout, false);

        // Set values to the views in the CardView
        ImageButton btnCard = cardView.findViewById(R.id.card_button);

        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //HANDLE CARD SELECTION
                //MAYBE USE A local boolean selected (must reset on play, discard, or click the card again)
            }
        });

        return cardView;
    }

}
