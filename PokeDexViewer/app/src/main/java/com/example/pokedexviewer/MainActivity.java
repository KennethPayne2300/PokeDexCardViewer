package com.example.pokedexviewer;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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

        //get
        ImageView pokemonImg;

        Pokemon[] pokemons = new Pokemon[3];

        Pokemon pikachu = new Pokemon("pikachu", "growl", "pika bolt", "fighting", "none", "When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.", 0.4, 6.0, 20, 30,1,0,70,R.drawable.pickachu,R.drawable.ElectricType);



    }
}