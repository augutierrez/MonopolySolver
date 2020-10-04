package com.example.monopolysolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import monopolyLogic.MonopolyCard;

public class BalanceAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;
    ArrayList<Integer> positions;
    ArrayList<Long> balances;
    int numPlayers;

    public BalanceAdapter(Context applicationContext, ArrayList<Integer> positions, ArrayList<Long> balances, int numPlayers){
        this.context=applicationContext;
        this.positions=positions;
        this.balances=balances;
        this.numPlayers=numPlayers;
        inflter=(LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return numPlayers;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.list_item3, null);
        TextView playerNum = view.findViewById(R.id.text_view2_list_item3);
        playerNum.setText(String.valueOf(position + 1));
        TextView playerBal = view.findViewById(R.id.balance_text2_list_item3);
        playerBal.setText(String.valueOf(balances.get(position)));
        TextView playerPos = view.findViewById(R.id.position_text2_list_item3);
        playerPos.setText(String.valueOf(positions.get(position) + 1));

        return view;
    }
}
