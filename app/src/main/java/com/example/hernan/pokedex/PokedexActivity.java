package com.example.hernan.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hernan.pokedex.DAOs.pokemonDAO;
import com.example.hernan.pokedex.DAOs.pokemon_pokedexDAO;
import com.example.hernan.pokedex.DAOs.usuarioDAO;
import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.pokemon_pokedex;
import com.example.hernan.pokedex.classes.usuario;

import java.util.ArrayList;

/**
 * Created by Hernan on 11/1/16.
 */
public class PokedexActivity extends AppCompatActivity{


    private int position;
    private pokemon_pokedexDAO ppDAO;
    private pokemonDAO pDAO;
    private usuario u;
    private RecyclerView rvPokedex;
    private ArrayList<pokemon> lista_pokemons = new ArrayList<pokemon>();
    private TextView tvEstado;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_capturar, menu);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_list_layout);

        u = (usuario) getIntent().getExtras().getSerializable(usuario.TABLE);

        Toast.makeText(this, u.mail, Toast.LENGTH_SHORT).show();

        pDAO = new pokemonDAO(this);

        for(int i = 1; i <= 151; i++){
            pokemon p = pDAO.getPokemonById(i);
            lista_pokemons.add(p);
        }

        rvPokedex = (RecyclerView) findViewById(R.id.rvPokedex);


        final pokemon_adapter adaptador = new pokemon_adapter(lista_pokemons, u);

        adaptador.setOnClcikListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerForContextMenu(v);

                position = rvPokedex.getChildPosition(v);

                ppDAO = new pokemon_pokedexDAO(PokedexActivity.this);


                if (ppDAO.isCapturado(u.id, lista_pokemons.get(position).species_id)) {
                    Intent notas_intent = new Intent(PokedexActivity.this, NotesActivity.class);
                    notas_intent.putExtra(usuario.TABLE, u);
                    notas_intent.putExtra(pokemon.TABLE, lista_pokemons.get(position));
                    startActivity(notas_intent);

                } else {
                    Toast.makeText(PokedexActivity.this, "Aún no has atrapado a " + lista_pokemons.get(position).identifier, Toast.LENGTH_LONG).show();


                }
            }
        });

        rvPokedex.setAdapter(adaptador);

        rvPokedex.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){

            case R.id.menu_capturar:
                pokemon_pokedex pp = new pokemon_pokedex();
                pp.species_id = lista_pokemons.get(position).species_id;
                pp.pokedex_id = u.id;
                ppDAO.insert(pp.pokedex_id, pp.species_id);

                ppDAO.updateCapturado(pp);

                tvEstado = (TextView) findViewById(R.id.tvEstadoLabel);
                tvEstado.setText(R.string.switch_text_on);

                break;

        }

        return super.onContextItemSelected(item);


    }

}
