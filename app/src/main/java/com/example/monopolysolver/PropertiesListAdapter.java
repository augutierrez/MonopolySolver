package com.example.monopolysolver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import monopolyLogic.MonopolyCard;

public class PropertiesListAdapter extends RecyclerView.Adapter<PropertiesListAdapter.ViewHolder>{
    public static ArrayList<MonopolyCard> properties;
    public static ArrayList<NumberPicker> npList;
    public static int numPlayers;
    public static ArrayList<ViewHolder> viewHolders;

    public  PropertiesListAdapter(ArrayList<MonopolyCard> properties, int numPlayers) {
        this.properties = properties;
        this.numPlayers=numPlayers;
        viewHolders=new ArrayList<>();
    }

    @NonNull
    @Override
    public PropertiesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item2, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.property.setText(properties.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView property;
        public EditText ownerEdit;
        public EditText hEdit;
        public ConstraintLayout constraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.property= (TextView) itemView.findViewById(R.id.text_view_list_item2);
            this.ownerEdit= itemView.findViewById(R.id.owner_text2_list_item2);
            ownerEdit.setText("0");
            this.hEdit= itemView.findViewById(R.id.owner_text2_list_item2);
            hEdit.setText("0");
            constraintLayout = (ConstraintLayout)itemView.findViewById(R.id.constraint_layout);
            viewHolders.add(this);
        }
    }
}


