package com.example.hernan.pokedex.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

        db.update(pokemon_pokedex.TABLE, values, pokemon_pokedex.KEY_pokedex_id + " = ?"
                        + " AND " + pokemon_pokedex.KEY_species_id + " = ?",
                         new String[]{String.valueOf(pp.pokedex_id), String.valueOf(pp.species_id)});

        db.close();

    }

    public void updateCapturado(pokemon_pokedex pp){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pokemon_pokedex.KEY_capturado, true);

        db.update(pokemon_pokedex.TABLE, values, pokemon_pokedex.KEY_pokedex_id + " = ?"
                        + " AND " + pokemon_pokedex.KEY_species_id + " = ?",
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

    public int insert(int pokedex_id, int species_id){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(pokemon_pokedex.KEY_pokedex_id, pokedex_id);
        values.put(pokemon_pokedex.KEY_species_id, species_id);
        values.put(pokemon_pokedex.KEY_visto, true);
        values.put(pokemon_pokedex.KEY_capturado, false);

        long pp_id = db.insert(pokemon_pokedex.TABLE, null, values);
        db.close();
        return (int) pp_id;

    }

    public boolean isCapturado(int pokedex_id, int species_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                pokemon_pokedex.KEY_capturado
                + " FROM " + pokemon_pokedex.TABLE
                + " WHERE " + pokemon_pokedex.KEY_pokedex_id + " = ? "
                + " AND " + pokemon_pokedex.KEY_species_id + " = ? ";

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(pokedex_id), String.valueOf(species_id)});
        boolean capturado = false;
        if(cursor.moveToFirst()){
            do{
              capturado  = (cursor.getInt(cursor.getColumnIndex(pokemon_pokedex.KEY_capturado)) == 1)? true : false;
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return capturado;

    }




}
