package com.example.pokedexviewer;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Pokemon {
    private String name, move1, move2, weakness, resistance, description;
    private Double length, weight;
    private int move1dmg, move2dmg, retreatCost, stage, health, pokemonImg, stageImg, typeImg;

    public Pokemon(String name, String move1, String move2, String weakness, String resistance, String description, Double length, Double weight, int move1dmg, int move2dmg, int retreatCost, int stage,int health, int pokemonImg, int stageImg, int typeImg){
        this.name=name;
        this.move1=move1;
        this.move2=move2;
        this.weakness=weakness;
        this.resistance=resistance;
        this.description=description;
        this.length=length;
        this.weight=weight;
        this.move1dmg=move1dmg;
        this.move2dmg=move2dmg;
        this.retreatCost=retreatCost;
        this.stage=stage;
        this.health=health;
        this.pokemonImg=pokemonImg;
        this.stageImg=stageImg;
        this.typeImg=typeImg;
    }

    public Pokemon(String name, String move1, String move2, String weakness, String resistance, String description, Double length, Double weight, int move1dmg, int move2dmg, int retreatCost, int stage,int health, int pokemonImg, int typeImg){
        this.name=name;
        this.move1=move1;
        this.move2=move2;
        this.weakness=weakness;
        this.resistance=resistance;
        this.description=description;
        this.length=length;
        this.weight=weight;
        this.move1dmg=move1dmg;
        this.move2dmg=move2dmg;
        this.retreatCost=retreatCost;
        this.stage=stage;
        this.health=health;
        this.pokemonImg=pokemonImg;
        this.typeImg=typeImg;
    }

    public void makeCard(ImageView pokemonIMG, TextView nameText, ImageView pokemonStageImage, TextView stageText, TextView hpText,ImageView typeImgView, TextView descriptionText, TextView lengthText, TextView weightText, TextView move1Text, TextView move1dmgText, TextView move2Text, TextView move2dmgText, TextView weaknessText, TextView resistanceText, LinearLayout retreatCostLayout, Context context){
        nameText.setText(name);
        pokemonIMG.setImageResource(pokemonImg);
        if(stageImg != 0){
            pokemonStageImage.setImageResource(stageImg);
        } else {
            pokemonStageImage.setVisibility(View.GONE);
        }
        stageText.setText(stage);
        hpText.setText(health);
        typeImgView.setImageResource(typeImg);
        descriptionText.setText(description);
        lengthText.setText(String.format("%f",length));
        weightText.setText(String.format("%f",weight));
        move1Text.setText(move1);
        move1dmgText.setText(move1dmg);
        move2Text.setText(move2);
        move2dmgText.setText(move2dmg);
        weaknessText.setText(weakness);
        resistanceText.setText(resistance);

        //repeat for how much retreat costs, add an image per retreat cost.
        for(int i=0; i<retreatCost; i++){
            //make the image view
            ImageView retreatSymbol = new ImageView(context);
            //set the image
            retreatSymbol.setImageResource(R.drawable.retreat_cost_symbol);
            //set the layout parameters
            retreatSymbol.setLayoutParams(new LinearLayout.LayoutParams(10,10));
            //add to layout
            retreatCostLayout.addView(retreatSymbol);
        }
    }
}
