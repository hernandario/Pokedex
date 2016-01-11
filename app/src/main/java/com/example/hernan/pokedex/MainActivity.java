package com.example.hernan.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.hernan.pokedex.DAOs.pokemonDAO;
import com.example.hernan.pokedex.DAOs.pokemon_speciesDAO;
import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.pokemon_species;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView lvPokedex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_list_layout);

        pokemonDAO pokeDao = new pokemonDAO(this);

        ArrayList<pokemon> pokemons = new ArrayList<pokemon>();

        for(int i = 1; i <= 151; i++){
            pokemon p = pokeDao.getPokemonById(i);
            pokemons.add(p);
            Log.i("pokemon agregado= ", p.identifier);
            Log.i("pokemon id= ", String.valueOf(p.id));
        }

        lvPokedex = (RecyclerView) findViewById(R.id.lvPokedex);

        pokemon_adapter adapter = new pokemon_adapter(pokemons);

        lvPokedex.setAdapter(adapter);
        lvPokedex.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
