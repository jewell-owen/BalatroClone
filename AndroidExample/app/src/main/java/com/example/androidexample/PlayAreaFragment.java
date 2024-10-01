package com.example.androidexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.androidexample.gamelogic.Card;
import com.example.androidexample.gamelogic.Game;

import java.util.ArrayList;

public class PlayAreaFragment extends Fragment implements View.OnClickListener {

    private Game game;
    private LinearLayout handLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_area, container, false);

        handLinearLayout = view.findViewById(R.id.play_hand_linearlayout);

        game = new Game();
        createCards(game.getHand());

        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();


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
        LayoutInflater inflater = LayoutInflater.from(getContext());
        CardView cardView = (CardView) inflater.inflate(R.layout.card_king_diamonds, handLinearLayout, false);

        // Set values to the views in the CardView
        ImageButton btnCard = cardView.findViewById(R.id.card_button);

        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PlayAreaFragment", "Card clicked");
                //HANDLE CARD SELECTION
                //MAYBE USE A local boolean selected (must reset on play, discard, or click the card again)
                //Or just array list oif selected cards probably easier
            }
        });

        return cardView;
    }
}