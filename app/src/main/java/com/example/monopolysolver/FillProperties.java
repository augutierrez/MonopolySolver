package com.example.monopolysolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import monopolyLogic.MonopolyCard;
import monopolyLogic.MonopolySolver;

public class FillProperties extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_properties);

        //MonopolySolver.generateDeck();

        final ListView recyclerView =  findViewById(R.id.recycler_view_fill_properties);
        //improves performance since the list stays a single size
        //recyclerView.setHasFixedSize(true);

        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);

        final int numPlayers = getIntent().getIntExtra("np", 2);
        //PropertiesListAdapter adapter = new PropertiesListAdapter(MonopolySolver.properties, numPlayers);
        PropertiesAdapter adapter = new PropertiesAdapter(getApplicationContext(), MonopolySolver.properties, numPlayers);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FillProperties.this, EditProperty.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }

        });
        Button button = findViewById(R.id.button_compute_winner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MonopolyCard> properties = PropertiesAdapter.properties;

                Log.i("properties", "size of prop:" + PropertiesAdapter.properties.size());
                for(int i = 0; i < properties.size(); i++){
                    MonopolyCard card = properties.get(i);
                    int position = card.getPos();

                    //updating the official deck
                    MonopolySolver.deck.set(position, card);

                    Log.i("properties", properties.get(i).getName());
                    Log.i("properties", "Belong to player:" + properties.get(i).getOwner());
                }

                Intent intent = new Intent(FillProperties.this, ComputeWinner.class);
                intent.putExtra("np", numPlayers);
                startActivity(intent);


            }
        });


    }
}
