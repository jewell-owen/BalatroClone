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
import com.example.androidexample.gamelogic.Suit;
import com.example.androidexample.gamelogic.Value;

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
        Suit suit;
        Value value;
        for (Card card : hand) {
            value = card.getEnumValue();
            suit = card.getSuit();
            CardView cardView = createCardView(suit, value);

            // Add the CardView to the LinearLayout (inside the HorizontalScrollView)
            handLinearLayout.addView(cardView);
        }

    }

    private CardView createCardView(Suit s, Value v)  {
        // Inflate the CardView layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        CardView cardView = null;
        switch (s){
            case HEART:
                switch (v){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_hearts, handLinearLayout, false);
                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_hearts, handLinearLayout, false);

                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_hearts, handLinearLayout, false);

                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_hearts, handLinearLayout, false);

                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_hearts, handLinearLayout, false);

                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_hearts, handLinearLayout, false);

                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_hearts, handLinearLayout, false);

                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_hearts, handLinearLayout, false);

                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_hearts, handLinearLayout, false);

                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_hearts, handLinearLayout, false);

                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_hearts, handLinearLayout, false);

                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_hearts, handLinearLayout, false);

                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_hearts, handLinearLayout, false);

                }
            case SPADE:
                switch (v){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_spades, handLinearLayout, false);

                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_spades, handLinearLayout, false);

                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_spades, handLinearLayout, false);

                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_spades, handLinearLayout, false);

                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_spades, handLinearLayout, false);

                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_spades, handLinearLayout, false);

                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_spades, handLinearLayout, false);

                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_spades, handLinearLayout, false);

                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_spades, handLinearLayout, false);

                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_spades, handLinearLayout, false);

                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_spades, handLinearLayout, false);

                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_spades, handLinearLayout, false);

                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_spades, handLinearLayout, false);

                }
            case CLUB:
                switch (v){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_clubs, handLinearLayout, false);

                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_clubs, handLinearLayout, false);

                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_clubs, handLinearLayout, false);

                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_clubs, handLinearLayout, false);

                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_clubs, handLinearLayout, false);

                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_clubs, handLinearLayout, false);

                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_clubs, handLinearLayout, false);

                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_clubs, handLinearLayout, false);

                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_clubs, handLinearLayout, false);

                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_clubs, handLinearLayout, false);

                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_clubs, handLinearLayout, false);

                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_clubs, handLinearLayout, false);

                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_clubs, handLinearLayout, false);

                }
            case DIAMOND:
                switch (v){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_diamonds, handLinearLayout, false);

                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_diamonds, handLinearLayout, false);

                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_diamonds, handLinearLayout, false);

                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_diamonds, handLinearLayout, false);

                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_diamonds, handLinearLayout, false);

                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_diamonds, handLinearLayout, false);

                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_diamonds, handLinearLayout, false);

                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_diamonds, handLinearLayout, false);

                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_diamonds, handLinearLayout, false);

                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_diamonds, handLinearLayout, false);

                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_diamonds, handLinearLayout, false);

                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_diamonds, handLinearLayout, false);
                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_diamonds, handLinearLayout, false);
                }
        }

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