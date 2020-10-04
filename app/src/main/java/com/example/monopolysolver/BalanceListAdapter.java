package com.example.monopolysolver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BalanceListAdapter extends RecyclerView.Adapter<BalanceListAdapter.ViewHolder>{
        private int numPlayers;
        public static ArrayList<EditText> balances;

        public  BalanceListAdapter(int numPlayers) {
            this.numPlayers = numPlayers;
            balances = new ArrayList<>();
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.list_item1, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.player.setText("Player " + (position + 1) + ": ");
        }


        @Override
        public int getItemCount() {
            return numPlayers;
        }

public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView player;
    public EditText editText;
    public ConstraintLayout constraintLayout;
    public ViewHolder(View itemView) {
        super(itemView);
        this.player = (TextView) itemView.findViewById(R.id.text_view_list_item);
        this.editText = itemView.findViewById(R.id.edit_text_list_item);
        constraintLayout = (ConstraintLayout)itemView.findViewById(R.id.constraint_layout);
        balances.add(editText);
    }
}
}

