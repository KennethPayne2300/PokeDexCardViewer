package com.example.pokedexviewer;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //get image views
        ImageView pokemonStageImg = findViewById(R.id.pokemonStageImageView);
        ImageView pokemonImg = findViewById(R.id.pokemonImageView);
        ImageView pokemonTypeImg = findViewById(R.id.pokemonTypeImageView);
        //get text views
        TextView pokemonNameText = findViewById(R.id.pokemonNameTextView);
        TextView pokemonStageText = findViewById(R.id.pokemonStageTextView);
        TextView pokemonHPText = findViewById(R.id.pokemonHPTextView);
        TextView pokemonDescriptionText = findViewById(R.id.pokemonDescriptionTextView);
        TextView pokemonLengthText = findViewById(R.id.pokemonLengthTextView);
        TextView pokemonWeightText = findViewById(R.id.pokemonWeightTextView);
        TextView pokemonMove1Text = findViewById(R.id.pokemonMove1TextView);
        TextView pokemonMove1PowerText = findViewById(R.id.pokemonMove1PowerTextView);
        TextView pokemonMove2Text = findViewById(R.id.pokemonMove2TextView);
        TextView pokemonMove2PowerText = findViewById(R.id.pokemonMove2PowerTextView);
        TextView pokemonWeaknessText = findViewById(R.id.pokemonWeaknessTextView);
        TextView pokemonResistanceText = findViewById(R.id.pokemonResistanceTextView);
        //get the retreat layout
        LinearLayout retreatLayout = findViewById(R.id.retreatCostLayout);

        Pokemon[] pokemons = new Pokemon[3];

        pokemons[0]=new Pokemon("pikachu", "growl", "pika bolt", "fighting", "none", "When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.", "Length: 0.4m", 13.2, 20, 30,1,0,70,R.drawable.pickachu,R.drawable.electrictype);
        //pokemons[1]=new Pokemon("Charizard", "Energy Burn", "Fire Spin", "Water", "Fighting", "If Charizard becomes truly angered, the flame at the tip of its tail burns in a light blue shade.","Height: 5'07\"", 199.5);
        try {
            pokemons[0].makeCard(pokemonImg, pokemonNameText, pokemonStageImg, pokemonStageText, pokemonHPText, pokemonTypeImg, pokemonDescriptionText, pokemonLengthText, pokemonWeightText, pokemonMove1Text, pokemonMove1PowerText, pokemonMove2Text, pokemonMove2PowerText, pokemonWeaknessText, pokemonResistanceText, retreatLayout, this);
        } catch(Exception e){
            Log.d("make card", e.toString());
        }
    }
}