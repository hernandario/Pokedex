package com.example.hernan.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hernan.pokedex.DAOs.pokemon_speciesDAO;
import com.example.hernan.pokedex.classes.pokemon;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemon_speciesDAO psDAO = new pokemon_speciesDAO(this);


    }
}
