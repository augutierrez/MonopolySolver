package com.example.monopolysolver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import monopolyLogic.MonopolyCard;
import monopolyLogic.MonopolyLogic;
import monopolyLogic.MonopolySolver;

public class ComputeWinner extends Activity {
    private BroadcastReceiver receiver;
    private TextView winText;
    private TextView roundText;
    private Button button;
    private int winner;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compute_winner);

        winText = findViewById(R.id.winner_text_computer_winner);
        winText.setText("Winner: Loading...");

        roundText = findViewById(R.id.rounds_text_compute_winner);
        roundText.setText("Loading...");

        button = findViewById(R.id.compute_again_compute_winner);
        button.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComputeWinner.this, ComputeWinner.class);
                //these flags clear the history of the activities
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Runnable solver = new Solver();
        Thread thread = new Thread(solver);
        //set priority to max to speed up the process
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    public class Solver implements Runnable {

        @Override
        public void run() {
            ArrayList<Long> bal = (ArrayList<Long>)MonopolySolver.balances.clone();
            ArrayList<Integer>pos = (ArrayList<Integer>)MonopolySolver.positions.clone();
            ArrayList<MonopolyCard> d = (ArrayList<MonopolyCard>)MonopolySolver.deck.clone();
            winner = MonopolyLogic.solveGame(bal, pos, d, 0) + 1;
            winText.post(new Runnable() {
                @Override
                public void run() {
                    winText.setText("Winner: Player " + winner);
                    roundText.setText("Rounds:" + MonopolyLogic.round);
                    button.setVisibility(View.VISIBLE);
                }
            });

        }
    }
}
