package com.example.monopolysolver;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import monopolyLogic.MonopolyLogic;
import monopolyLogic.MonopolySolver;

public class FillBalance extends AppCompatActivity {
    public int numPlayers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_balance);

        final RecyclerView recyclerView =  (RecyclerView) findViewById(R.id.recycler_view_fill_balance);
        //improves performance since the list stays a single size
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        numPlayers = getIntent().getIntExtra("np", 2);
        BalanceListAdapter adapter = new BalanceListAdapter(numPlayers);
        recyclerView.setAdapter(adapter);

        Button button = findViewById(R.id.button_fill_balance);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Long> players = new ArrayList<>();
                for(int i = 0; i < BalanceListAdapter.balances.size(); i++){
                    EditText editText = BalanceListAdapter.balances.get(i);
                    String num = editText.getText().toString();
                    if(num.isEmpty()){
                        num = "0";
                    }
                    players.add((long)(Integer.parseInt(num)));
                    Log.i("balance" , editText.getText().toString());
                    Intent intent = new Intent(FillBalance.this, FillProperties.class);
                    intent.putExtra("np", numPlayers);
                    startActivity(intent);
                }
                MonopolySolver.generateDeck();

                //filled MonopolyLog.players
                MonopolyLogic.players = players;

            }
        });

    }
}
