package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokemon;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemonDAO {

    private DBHelper dbHelper;

    public pokemonDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public pokemon getPokemonById(int pokemon_id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT "
                + pokemon.KEY_id + ", "
                + pokemon.KEY_identifier + ", "
                + pokemon.KEY_species_id + ", "
                + pokemon.KEY_height + ", "
                + pokemon.KEY_weight + ", "
                + pokemon.KEY_base_experience + ", "
                + pokemon.KEY_order
                + " FROM " + pokemon.TABLE
                + " WHERE " + " = ?";

        pokemon poke = new pokemon();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(pokemon_id)});

        if(cursor.moveToFirst()){
            do{
                poke.id = cursor.getInt(cursor.getColumnIndex(pokemon.KEY_id));
                poke.identifier = cursor.getString(cursor.getColumnIndex(pokemon.KEY_identifier));
                poke.species_id = cursor.getInt(cursor.getColumnIndex(pokemon.KEY_species_id));
                poke.height = cursor.getInt(cursor.getColumnIndex(pokemon.KEY_height));
                poke.weight = cursor.getInt(cursor.getColumnIndex(pokemon.KEY_weight));
                poke.base_experience = cursor.getInt(cursor.getColumnIndex(pokemon.KEY_base_experience));
                poke.order = cursor.getInt(cursor.getColumnIndex(pokemon.KEY_order));
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return poke;
    }


}
