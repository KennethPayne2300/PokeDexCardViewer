package com.example.pokedexviewer;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView pokemonStageImg, pokemonImg, pokemonTypeImg;
    private TextView pokemonNameText,pokemonStageText,pokemonHPText,pokemonDescriptionText,pokemonLengthText,pokemonWeightText,pokemonMove1Text,pokemonMove1PowerText,pokemonMove2Text,pokemonMove2PowerText,pokemonWeaknessText,pokemonResistanceText;
    private LinearLayout retreatLayout;
    private Spinner pokeSpinner;
    int index;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<String> pokemonNames;

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
        //get the Spinner
        pokeSpinner = findViewById(R.id.PokeSpinner);

        index = 0;

        pokemons = new ArrayList<>();
        //add pokemons to the pokemon list
        pokemons.add(new Pokemon("pikachu", "growl", "pika bolt", "fighting", "none", "When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.", "Length: 0.4m", 13.2, 20, 30,1,0,70,R.drawable.pickachu,R.drawable.electrictype));
        pokemons.add(new Pokemon("Charizard", "Brave Wing", "Explosive Vortex", "Water", "none", "If Charizard becomes truly angered, the flame at the tip of its tail burns in a light blue shade.","Height: 5'07\"", 199.5,60,330,2,2,330,R.drawable.charizard,R.drawable.babycharizard,R.drawable.firetype));
        pokemons.add(new Pokemon("Squrtle","Tackle","Rain Splash","grass","none","After birth, its back swells and hardens into a shell. It sprays a potent foam from its mouth","Height: 1'08\"",19.8,10,20,1,0,70,R.drawable.squirtle,R.drawable.watertype));
        //start with the first pokemon in the list
        makeCard(pokemons.get(0));
        //separate array list so that we can see the pokemon names
        pokemonNames = new ArrayList<>();
        //add pokemon names to pokemonNames list
        pokemonNames.add(pokemons.get(0).getName());
        pokemonNames.add(pokemons.get(1).getName());
        pokemonNames.add(pokemons.get(2).getName());

        pokeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                String item = adapterView.getItemAtPosition(i).toString();
                for(Pokemon pokemon:pokemons){
                    if(item.equals(pokemon.getName())){
                        retreatLayout.removeAllViews();
                        makeCard(pokemon);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //array adapter to put the names array, into the spinner so we can choose with it.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.poke_spinner_item,pokemonNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        pokeSpinner.setAdapter(arrayAdapter);
    }
    public void makeCard(Pokemon pokemon){
        //set the text and images to the data in the pokemon class
        pokemonNameText.setText(pokemon.getName());
        pokemonImg.setImageResource(pokemon.getPokemonImg());
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