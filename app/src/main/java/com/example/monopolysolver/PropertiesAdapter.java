package com.example.monopolysolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import monopolyLogic.MonopolyCard;

public class PropertiesAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;
    public static ArrayList<MonopolyCard> properties;
    int numPlayers;

    public PropertiesAdapter(Context applicationContext, ArrayList<MonopolyCard> properties, int numPlayers){
        this.context=applicationContext;
        this.properties=properties;
        this.numPlayers=numPlayers;
        inflter=(LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return properties.size();
    }

    @Override
    public Object getItem(int position) {
        return properties.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.list_item2, null);
        TextView property = view.findViewById(R.id.text_view_list_item2);
        property.setText(properties.get(position).getName());
        TextView ownerEdit = view.findViewById(R.id.owner_text2_list_item2);
        ownerEdit.setText(String.valueOf(properties.get(position).getOwner()));
        TextView hEdit = view.findViewById(R.id.h_value_text2_list_item2);
        hEdit.setText(String.valueOf(properties.get(position).gethValue()));
        return view;
    }
}
