package com.example.hernan.pokedex;

import android.content.Context;
import android.content.SharedPreferences;
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
public class pokemon_adapter extends ArrayAdapter<pokemon> {


    SharedPreferences user_preferences;

    public pokemon_adapter(Context context, ArrayList<pokemon> pokemons){
        super(context, R.layout.pokemon_view_layout, pokemons);

        user_preferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if( item == null){

            LayoutInflater inflador = LayoutInflater.from(getContext());
            item = inflador.inflate(R.layout.pokemon_view_layout, null);

            holder = new ViewHolder();

            holder.imgPokemon = (ImageView) item.findViewById(R.id.imgPokemon);
            holder.tvPokemonName = (TextView) item.findViewById(R.id.tvPokemonName);
            holder.tvAltura = (TextView) item.findViewById(R.id.tvAltura);
            holder.tvPeso = (TextView) item.findViewById(R.id.tvPeso);
            holder.btnswitchEstado = (Switch) item.findViewById(R.id.btnswitchEstado);

        }

        else{
            holder = (ViewHolder) item.getTag();
        }

        int recursoImagen = this.getContext().getResources().getIdentifier("pokemon_" + (super.getItem(position).id), "drawable", "com.example.hernan.pokedex" );

        if(recursoImagen != 0)
            holder.imgPokemon.setImageResource(recursoImagen);

        else
            holder.imgPokemon.setImageResource(R.drawable.pokemon_0);


        holder.tvPokemonName.setText(super.getItem(position).identifier);
        holder.tvAltura.setText(super.getItem(position).height);
        holder.tvPeso.setText(super.getItem(position).weight);


        int pokedex_id = Integer.parseInt(user_preferences.getString("pokedex_id", "0"));
        pokemon_pokedexDAO ppDAO = new pokemon_pokedexDAO(super.getContext());

        if(ppDAO.isCapturado(pokedex_id, super.getItem(position).species_id))
            holder.btnswitchEstado.setChecked(true);

        else
            holder.btnswitchEstado.setChecked(false);


        return item;


    }


    static class ViewHolder{

        ImageView imgPokemon;
        TextView tvPokemonName, tvAltura, tvPeso;
        Switch btnswitchEstado;

    }
}
