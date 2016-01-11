package com.example.hernan.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.example.hernan.pokedex.DAOs.notasDAO;
import com.example.hernan.pokedex.DAOs.pokemonDAO;
import com.example.hernan.pokedex.DAOs.pokemon_speciesDAO;
import com.example.hernan.pokedex.classes.notas;
import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.pokemon_species;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView lvPokedex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_list_layout);

        notasDAO pokeDao = new notasDAO(this);

        ArrayList<notas> pokemons = new ArrayList<notas>();

        for(int i = 1; i <= 151; i++){
            notas n = new notas();
            n.texto = "Hola " + i;
            pokemons.add(n);
        }

        lvPokedex = (RecyclerView) findViewById(R.id.lvNotas);

        note_adapter adapter = new note_adapter(pokemons);

        lvPokedex.setAdapter(adapter);
        lvPokedex.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
