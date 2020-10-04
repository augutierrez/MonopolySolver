package com.example.monopolysolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import monopolyLogic.MonopolyCard;
import monopolyLogic.MonopolyLogic;
import monopolyLogic.MonopolySolver;

public class ComputeWinner extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compute_winner);
        //+1 to match user index
        ArrayList<Long> bal = (ArrayList<Long>)MonopolySolver.balances.clone();
        ArrayList<Integer>pos = (ArrayList<Integer>)MonopolySolver.positions.clone();
        ArrayList<MonopolyCard> d = (ArrayList<MonopolyCard>)MonopolySolver.deck.clone();
        int winner = MonopolyLogic.solveGame(bal, pos, d, 0) + 1;

        TextView winText = findViewById(R.id.winner_text_computer_winner);
        winText.setText("Winner: Player " + winner);

        TextView roundText = findViewById(R.id.rounds_text_compute_winner);
        roundText.setText("Rounds:" + MonopolyLogic.round);

        Button button = findViewById(R.id.compute_again_compute_winner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComputeWinner.this, ComputeWinner.class);
                startActivity(intent);
            }
        });
    }
}
