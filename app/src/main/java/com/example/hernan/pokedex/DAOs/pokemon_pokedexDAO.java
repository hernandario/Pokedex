package com.example.hernan.pokedex.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokemon_pokedex;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_pokedexDAO {

    private DBHelper dbHelper;

    public pokemon_pokedexDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public void updateVisto(pokemon_pokedex pp){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pokemon_pokedex.KEY_visto, true);

        db.update(pokemon_pokedex.TABLE, values, pokemon_pokedex.KEY_pokedex_id + " = ?" + " AND " + pokemon_pokedex.KEY_species_id + " = ?",
                new String[]{String.valueOf(pp.pokedex_id), String.valueOf(pp.species_id)});

        db.close();

    }

    public void updateCapturado(pokemon_pokedex pp){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pokemon_pokedex.KEY_capturado, true);

        db.update(pokemon_pokedex.TABLE, values, pokemon_pokedex.KEY_pokedex_id + " = ?" + " AND " + pokemon_pokedex.KEY_species_id + " = ?",
                new String[]{String.valueOf(pp.pokedex_id), String.valueOf(pp.species_id)});

        db.close();

    }

    public void updateLiberado(pokemon_pokedex pp){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pokemon_pokedex.KEY_capturado, false);

        db.update(pokemon_pokedex.TABLE, values, pokemon_pokedex.KEY_pokedex_id + " = ?" + " AND " + pokemon_pokedex.KEY_species_id + " = ?",
                new String[]{String.valueOf(pp.pokedex_id), String.valueOf(pp.species_id)});

        db.close();

    }


}
