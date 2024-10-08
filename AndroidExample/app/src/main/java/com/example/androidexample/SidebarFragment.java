package com.example.androidexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.androidexample.gamelogic.Game;

public class SidebarFragment extends Fragment implements View.OnClickListener {

    private Game game;
    private TextView discardsTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sidebar, container, false);

        discardsTextView = view.findViewById(R.id.sidebar_remaining_discards_tv);

        this.game = ((PlayActivity)getActivity()).getGame();
        return view;
    }

        @Override
    public void onClick(View view) {
        int id = view.getId();

    }

    public void updateDiscards(int discards){
        discardsTextView.setText(String.valueOf(discards));
    }

    public void setGame(Game game){
        this.game = game;
    }

}
