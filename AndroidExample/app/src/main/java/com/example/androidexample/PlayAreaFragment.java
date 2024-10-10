package com.example.androidexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Button discardButton;
    private Button sortRankButton;
    private Button sortSuitButton;
    private CardView cardView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_area, container, false);

        handLinearLayout = view.findViewById(R.id.play_hand_linearlayout);
        discardButton = view.findViewById(R.id.play_discard_btn);
        sortRankButton = view.findViewById(R.id.play_sort_rank_btn);
        sortSuitButton = view.findViewById(R.id.play_sort_suit_btn);

        this.game = ((PlayActivity)getActivity()).getGame();
        game.startRoundDeal();
        createCards(game.getHand());
        //Log.d("PlayAreaFragment", "Hand : " + game.handToString());
        //Log.d("PlayAreaFragment", "Deck : " + game.deckToString());

        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PlayAreaFragment", "Discard button clicked");
                game.discardSelectedCards();
            }
        });

        sortRankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PlayAreaFragment", "Sort rank button clicked");
                game.sortHandByRank();

            }
        });

        sortSuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PlayAreaFragment", "Sort suit button clicked");
                game.sortHandBySuit();
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
    }

    public void updateHand(ArrayList<Card> hand){
        handLinearLayout.removeAllViews();
        createCards(hand);
    }

    private void createCards(ArrayList<Card> hand) {
        // Create a new CardView for each card
        for (Card card : hand) {
            CardView cardView = createCardView(card);

            // Add the CardView to the LinearLayout (inside the HorizontalScrollView)
            handLinearLayout.addView(cardView);
        }

    }

    private CardView createCardView(Card card)  {
        // Inflate the CardView layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        cardView = null;
        Suit suit = card.getSuit();
        Value value = card.getEnumValue();
        switch (suit){
            case HEART:
                switch (value){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_hearts, handLinearLayout, false);
                        break;
                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_hearts, handLinearLayout, false);
                        break;
                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_hearts, handLinearLayout, false);
                        break;
                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_hearts, handLinearLayout, false);
                        break;
                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_hearts, handLinearLayout, false);
                        break;
                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_hearts, handLinearLayout, false);
                        break;
                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_hearts, handLinearLayout, false);
                        break;
                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_hearts, handLinearLayout, false);
                        break;
                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_hearts, handLinearLayout, false);
                        break;
                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_hearts, handLinearLayout, false);
                        break;
                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_hearts, handLinearLayout, false);
                        break;
                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_hearts, handLinearLayout, false);
                        break;
                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_hearts, handLinearLayout, false);
                        break;
                }
                break;
            case SPADE:
                switch (value){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_spades, handLinearLayout, false);
                        break;
                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_spades, handLinearLayout, false);
                        break;
                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_spades, handLinearLayout, false);
                        break;
                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_spades, handLinearLayout, false);
                        break;
                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_spades, handLinearLayout, false);
                        break;
                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_spades, handLinearLayout, false);
                        break;
                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_spades, handLinearLayout, false);
                        break;
                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_spades, handLinearLayout, false);
                        break;
                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_spades, handLinearLayout, false);
                        break;
                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_spades, handLinearLayout, false);
                        break;
                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_spades, handLinearLayout, false);
                        break;
                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_spades, handLinearLayout, false);
                        break;
                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_spades, handLinearLayout, false);
                        break;
                }
                break;
            case CLUB:
                switch (value){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_clubs, handLinearLayout, false);
                        break;
                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_clubs, handLinearLayout, false);
                        break;
                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_clubs, handLinearLayout, false);
                        break;
                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_clubs, handLinearLayout, false);
                        break;
                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_clubs, handLinearLayout, false);
                        break;
                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_clubs, handLinearLayout, false);
                        break;
                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_clubs, handLinearLayout, false);
                        break;
                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_clubs, handLinearLayout, false);
                        break;
                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_clubs, handLinearLayout, false);
                        break;
                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_clubs, handLinearLayout, false);
                        break;
                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_clubs, handLinearLayout, false);
                        break;
                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_clubs, handLinearLayout, false);
                        break;
                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_clubs, handLinearLayout, false);
                        break;
                }
                break;
            case DIAMOND:
                switch (value){
                    case ONE:
                        cardView = (CardView) inflater.inflate(R.layout.card_ace_diamonds, handLinearLayout, false);
                        break;
                    case TWO:
                        cardView = (CardView) inflater.inflate(R.layout.card_two_diamonds, handLinearLayout, false);
                        break;
                    case THREE:
                        cardView = (CardView) inflater.inflate(R.layout.card_three_diamonds, handLinearLayout, false);
                        break;
                    case FOUR:
                        cardView = (CardView) inflater.inflate(R.layout.card_four_diamonds, handLinearLayout, false);
                        break;
                    case FIVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_five_diamonds, handLinearLayout, false);
                        break;
                    case SIX:
                        cardView = (CardView) inflater.inflate(R.layout.card_six_diamonds, handLinearLayout, false);
                        break;
                    case SEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_seven_diamonds, handLinearLayout, false);
                        break;
                    case EIGHT:
                        cardView = (CardView) inflater.inflate(R.layout.card_eight_diamonds, handLinearLayout, false);
                        break;
                    case NINE:
                        cardView = (CardView) inflater.inflate(R.layout.card_nine_diamonds, handLinearLayout, false);
                        break;
                    case TEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_ten_diamonds, handLinearLayout, false);
                        break;
                    case ELEVEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_jack_diamonds, handLinearLayout, false);
                        break;
                    case TWELVE:
                        cardView = (CardView) inflater.inflate(R.layout.card_queen_diamonds, handLinearLayout, false);
                        break;
                    case THIRTEEN:
                        cardView = (CardView) inflater.inflate(R.layout.card_king_diamonds, handLinearLayout, false);
                        break;
                }
                break;
        }

        cardView.setBackgroundResource(0);

        // Set values to the views in the CardView
        ImageButton btnCard = cardView.findViewById(R.id.card_button);

        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PlayAreaFragment", "Card clicked: " + value.toString() + suit.toString());
                //HANDLE CARD SELECTION
                if (game.getSelectedCards().contains(card)){
                    game.deselectCard(card);
                    cardView.setBackgroundResource(0);
                }
                else{
                    if (game.getSelectedCards().size() < 5){
                        game.selectCard(card);
                        cardView.setBackgroundResource(R.drawable.select_overlay);

                    }
                }
            }
        });

        return cardView;
    }

    public void setGame(Game game){
        this.game = game;
    }
}