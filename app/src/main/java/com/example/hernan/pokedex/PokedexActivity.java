package com.example.hernan.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.hernan.pokedex.DAOs.pokemonDAO;
import com.example.hernan.pokedex.DAOs.pokemon_pokedexDAO;
import com.example.hernan.pokedex.DAOs.usuarioDAO;
import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.usuario;

import java.util.ArrayList;

/**
 * Created by Hernan on 11/1/16.
 */
public class PokedexActivity extends AppCompatActivity{


    private usuario u;
    private RecyclerView rvPokedex;
    private ArrayList<pokemon> lista_pokemons = new ArrayList<pokemon>();
    private Switch estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_list_layout);

        u = (usuario) getIntent().getExtras().getSerializable(usuario.TABLE);

        Toast.makeText(this, u.mail, Toast.LENGTH_SHORT).show();

        pokemonDAO pDAO = new pokemonDAO(this);

        for(int i = 1; i <= 151; i++){
            pokemon p = pDAO.getPokemonById(i);
            lista_pokemons.add(p);
        }

        rvPokedex = (RecyclerView) findViewById(R.id.rvPokedex);

        final pokemon_adapter adaptador = new pokemon_adapter(lista_pokemons);

        adaptador.setOnClcikListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pokemon_pokedexDAO ppDAO = new pokemon_pokedexDAO(PokedexActivity.this);


                if(ppDAO.isCapturado(u.id, lista_pokemons.get(rvPokedex.getChildPosition(v)).species_id)){



                    Intent notas_intent = new Intent(PokedexActivity.this, NotesActivity.class);
                    notas_intent.putExtra("usuario", u);
                    notas_intent.putExtra("pokemon", lista_pokemons.get(rvPokedex.getChildPosition(v)));
                    startActivity(notas_intent);
                    
                }

                else
                    Toast.makeText(PokedexActivity.this, "Aún no has atrapado a " + lista_pokemons.get(rvPokedex.getChildPosition(v)).identifier, Toast.LENGTH_LONG).show();

            }
        });

        rvPokedex.setAdapter(adaptador);

        rvPokedex.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));



        estado = (Switch) findViewById(R.id.btnswitchEstado);




    }
}
