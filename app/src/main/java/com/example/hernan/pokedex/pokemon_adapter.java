package com.example.hernan.pokedex;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.pokemon_pokedex;
import com.example.hernan.pokedex.DAOs.pokemon_pokedexDAO;
import com.example.hernan.pokedex.classes.pokemon_species;

import java.util.ArrayList;

/**
 * Created by Hernan on 10/1/16.
 */
public class pokemon_adapter extends RecyclerView.Adapter<pokemon_adapter.pokemonViewHolder>{


    private ArrayList<pokemon> pokemons;
    static SharedPreferences user_preferences;

    public pokemon_adapter(ArrayList<pokemon> pokemons){

        this.pokemons = pokemons;


    }


    @Override
    public pokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        pokemonViewHolder pvh;

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_view_layout, parent, false);

        pvh = new pokemonViewHolder(itemView);

        return pvh;
    }

    @Override
    public void onBindViewHolder(pokemonViewHolder holder, int position) {

        pokemon p = pokemons.get(position);

        holder.bindPokemon(p);

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    static class pokemonViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPokemon;
        private TextView tvPokemonName, tvAltura, tvPeso;
        private Switch btnswitchEstado;

        public pokemonViewHolder(View itemView) {
            super(itemView);

            user_preferences = itemView.getContext().getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

            imgPokemon = (ImageView) itemView.findViewById(R.id.imgPokemon);
            tvPokemonName = (TextView) itemView.findViewById(R.id.tvPokemonName);
            tvAltura = (TextView) itemView.findViewById(R.id.tvAltura);
            tvPeso = (TextView) itemView.findViewById(R.id.tvPeso);
            btnswitchEstado = (Switch) itemView.findViewById(R.id.btnswitchEstado);

        }

        public void bindPokemon(pokemon p){

            int recursoImagen = itemView.getContext().getResources().getIdentifier("pokemon_" + (p.id), "drawable", "com.example.hernan.pokedex" );

            if(recursoImagen != 0)
                imgPokemon.setImageResource(recursoImagen);

            else
                imgPokemon.setImageResource(R.drawable.pokemon_0);


            tvPokemonName.setText(p.identifier);
            tvAltura.setText(String.valueOf(p.height));
            tvPeso.setText(String.valueOf(p.weight));


        /*
        int pokedex_id = Integer.parseInt(user_preferences.getString("pokedex_id", "0"));
        pokemon_pokedexDAO ppDAO = new pokemon_pokedexDAO(itemView.getContext());

        if(ppDAO.isCapturado(pokedex_id, p.species_id))
            btnswitchEstado.setChecked(true);

        else
            btnswitchEstado.setChecked(false);
*/


        }
    }
}
