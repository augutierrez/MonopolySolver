package com.example.monopolysolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import monopolyLogic.MonopolySolver;

public class EditBalance extends AppCompatActivity {
    public int pos;
    public int numPlayers;
    public EditText editBal;
    public EditText editPos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_balance);

        pos = getIntent().getIntExtra("pos", 0);
        numPlayers = getIntent().getIntExtra("np", 2);

        TextView playerPos = findViewById(R.id.text_view2_edit_balance);
        playerPos.setText(String.valueOf(pos + 1));

        editBal = findViewById(R.id.balance_edit_edit_balance);
        editPos = findViewById(R.id.position_edit_edit_balance);

        Button button = findViewById(R.id.save_button_edit_balance);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b = editBal.getText().toString();
                if(b.isEmpty()){
                    b = "0";
                }
                MonopolySolver.balances.set(pos, (long)Integer.parseInt(b));

                String p = editPos.getText().toString();
                if(p.isEmpty()){
                    p = "0";
                }
                MonopolySolver.positions.set(pos, Integer.parseInt(p) - 1);

                Intent intent = new Intent(EditBalance.this, FillBalance.class);
                intent.putExtra("np", numPlayers);
                startActivity(intent);

            }
        });

    }
}
