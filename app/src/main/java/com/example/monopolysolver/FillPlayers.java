package com.example.monopolysolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FillPlayers extends AppCompatActivity {
    public NumberPicker np;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_players);

        np = findViewById(R.id.np_fill_name);
        np.setMinValue(2);
        np.setMaxValue(5);
        int numPlayers = np.getValue();

        Button button = findViewById(R.id.button_fill_players);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillPlayers.this, FillBalance.class);
                intent.putExtra("np", (int)np.getValue());
                startActivity(intent);
            }
        });
    }
}
