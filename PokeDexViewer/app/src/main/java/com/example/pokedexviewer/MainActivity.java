package com.example.pokedexviewer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView pokemonStageImg, pokemonImg, pokemonTypeImg;
    private TextView pokemonNameText,pokemonStageText,pokemonHPText,pokemonDescriptionText,pokemonLengthText,pokemonWeightText,pokemonMove1Text,pokemonMove1PowerText,pokemonMove2Text,pokemonMove2PowerText,pokemonWeaknessText,pokemonResistanceText;
    private LinearLayout retreatLayout;
    private Button backBTN,nextBTN;
    int index;
    private Pokemon[] pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //get image views
        pokemonStageImg = findViewById(R.id.pokemonStageImageView);
        pokemonImg = findViewById(R.id.pokemonImageView);
        pokemonTypeImg = findViewById(R.id.pokemonTypeImageView);
        //get text views
        pokemonNameText = findViewById(R.id.pokemonNameTextView);
        pokemonStageText = findViewById(R.id.pokemonStageTextView);
        pokemonHPText = findViewById(R.id.pokemonHPTextView);
        pokemonDescriptionText = findViewById(R.id.pokemonDescriptionTextView);
        pokemonLengthText = findViewById(R.id.pokemonLengthTextView);
        pokemonWeightText = findViewById(R.id.pokemonWeightTextView);
        pokemonMove1Text = findViewById(R.id.pokemonMove1TextView);
        pokemonMove1PowerText = findViewById(R.id.pokemonMove1PowerTextView);
        pokemonMove2Text = findViewById(R.id.pokemonMove2TextView);
        pokemonMove2PowerText = findViewById(R.id.pokemonMove2PowerTextView);
        pokemonWeaknessText = findViewById(R.id.pokemonWeaknessTextView);
        pokemonResistanceText = findViewById(R.id.pokemonResistanceTextView);
        //get the retreat layout
        retreatLayout = findViewById(R.id.retreatCostLayout);
        //get buttons
        backBTN = findViewById(R.id.previousCardBTN);
        nextBTN = findViewById(R.id.nextCardBTN);

        index = 0;

        pokemons = new Pokemon[3];
        //add pokemons to the pokemon list
        pokemons[0]=new Pokemon("pikachu", "growl", "pika bolt", "fighting", "none", "When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.", "Length: 0.4m", 13.2, 20, 30,1,0,70,R.drawable.pickachu,R.drawable.electrictype);
        pokemons[1]=new Pokemon("Charizard", "Brave Wing", "Explosive Vortex", "Water", "none", "If Charizard becomes truly angered, the flame at the tip of its tail burns in a light blue shade.","Height: 5'07\"", 199.5,60,330,2,2,330,R.drawable.charizard,R.drawable.babycharizard,R.drawable.firetype);
        pokemons[2]=new Pokemon("Squrtle","Tackle","Rain Splash","grass","none","After birth, its back swells and hardens into a shell. It sprays a potent foam from its mouth","Height: 1'08\"",19.8,10,20,1,0,70,R.drawable.squirtle,R.drawable.watertype);
        //start with the first pokemon in the list
        makeCard(pokemons[0]);

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset retreat cost images
                retreatLayout.removeAllViews();
                //change to the previous pokemon and if its at the start of the list go to the last pokemon
                if(index>0){
                    index--;
                } else{
                    index=pokemons.length-1;
                }
                //make the card
                makeCard(pokemons[index]);
            }
        });
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset retreat cost images
                retreatLayout.removeAllViews();
                //change to the next pokemon and if its at end of the list go to the first pokemon in it.
                if(index<pokemons.length-1){
                    index++;
                } else{
                    index=0;
                }
                try {
                    makeCard(pokemons[index]);
                } catch (Exception e){
                    Log.d("make card", e.toString());
                }
            }
        });
    }
    public void makeCard(Pokemon pokemon){
        pokemonNameText.setText(pokemon.getName());
        pokemonImg.setImageResource(pokemon.getPokemonImg());
        Log.d("pokemon image",pokemon.getTypeImg()+" "+pokemon.getName());
        if(pokemon.getStageImg() != 0){
            pokemonStageImg.setImageResource(pokemon.getStageImg());
            pokemonStageImg.setVisibility(View.VISIBLE);
        } else {
            pokemonStageImg.setVisibility(View.GONE);
        }
        pokemonStageText.setText(String.format("Stage %d", pokemon.getStage()));
        pokemonHPText.setText(String.format("%d hp",pokemon.getHealth()));
        pokemonTypeImg.setImageResource(pokemon.getTypeImg());
        pokemonDescriptionText.setText(pokemon.getDescription());
        pokemonLengthText.setText(pokemon.getLength());
        pokemonWeightText.setText(String.format("weight: %.1f lbs",pokemon.getWeight()));
        pokemonMove1Text.setText(pokemon.getMove1());
        pokemonMove1PowerText.setText(String.format("%d",pokemon.getMove1dmg()));
        pokemonMove2Text.setText(pokemon.getMove2());
        pokemonMove2PowerText.setText(String.format("%d",pokemon.getMove2dmg()));
        pokemonWeaknessText.setText(pokemon.getWeakness());
        pokemonResistanceText.setText(pokemon.getResistance());

        //repeat for how much retreat costs, add an image per retreat cost.
        for(int i=0; i<pokemon.getRetreatCost(); i++){
            //make the image view
            ImageView retreatSymbol = new ImageView(this);
            //set the image
            retreatSymbol.setImageResource(R.drawable.retreat_symbol);
            //set the layout parameters
            retreatSymbol.setLayoutParams(new LinearLayout.LayoutParams(50,50));
            //add to layout
            retreatLayout.addView(retreatSymbol);
        }
    }
}