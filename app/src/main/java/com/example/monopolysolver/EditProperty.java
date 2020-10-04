package com.example.monopolysolver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import monopolyLogic.MonopolyCard;
import monopolyLogic.MonopolyLogic;
import monopolyLogic.MonopolySolver;

public class EditProperty extends AppCompatActivity {
    public int pos;
    public EditText ownerEdit;
    public EditText hEdit;
    public boolean successfulChange;
    public boolean hChange;
    public boolean pChange;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_property);

        pos = getIntent().getIntExtra("pos", 0);
        pChange = true;

        TextView propertyName = findViewById(R.id.text_view_edit_property);
        propertyName.setText(MonopolySolver.properties.get(pos).getName());
        ownerEdit = findViewById(R.id.owner_edit_edit_property);
        hEdit = findViewById(R.id.h_value_edit_edit_property);


        Button button = findViewById(R.id.save_button_edit_property);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updating owner
                String p = ownerEdit.getText().toString();
                if(p.isEmpty()){
                    p = "-1";
                    pChange=false;
                }
                MonopolySolver.properties.get(pos).setPlayer(Integer.parseInt(p));
                //updating hValue
                String h = hEdit.getText().toString();
                if(h.isEmpty()){
                    h = "0";
                }
                int hValue = Integer.parseInt(h);
                MonopolySolver.properties.get(pos).sethValue(hValue);
                if(hValue == 1){
                    MonopolySolver.properties.get(pos).has1house();
                }
                else if(hValue == 2){
                    MonopolySolver.properties.get(pos).has2house();
                }
                else if(hValue == 3){
                    MonopolySolver.properties.get(pos).has3house();
                }
                else if(hValue == 4){
                    MonopolySolver.properties.get(pos).has4house();
                }
                else if(hValue == 5){
                    MonopolySolver.properties.get(pos).hashotel();
                }

                /*
                deleting card and placing it back in properties to get it to the end of the list,
                this is strictly to improve user experience while filling out all the properties.
                 */

                if(pChange) {
                    MonopolyCard card = MonopolySolver.properties.get(pos);
                    MonopolySolver.properties.remove(pos);
                    MonopolySolver.properties.add(card);
                }
                Intent intent = new Intent(EditProperty.this, FillProperties.class);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        });


    }
}
