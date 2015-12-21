package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokemon_species_names;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_species_namesDAO {

    private DBHelper dbHelper;

    public pokemon_species_namesDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public pokemon_species_names getNamebyId(int species_id, int langage_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT "
                + pokemon_species_names.KEY_pokemon_species_id + ", "
                + pokemon_species_names.KEY_local_language_id+ ", "
                + pokemon_species_names.KEY_name + ", "
                + pokemon_species_names.KEY_genus
                + " FROM " + pokemon_species_names.TABLE
                + " WHERE " + pokemon_species_names.KEY_pokemon_species_id + " = ?"
                + " AND " + pokemon_species_names.KEY_local_language_id + " = ?";


        pokemon_species_names name = new pokemon_species_names();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(species_id), String.valueOf(langage_id)});

        if(cursor.moveToFirst()){
            do{
                name.pokemon_species_id = cursor.getInt(cursor.getColumnIndex(pokemon_species_names.KEY_pokemon_species_id));
                name.local_language_id = cursor.getInt(cursor.getColumnIndex(pokemon_species_names.KEY_local_language_id));
                name.name = cursor.getString(cursor.getColumnIndex(pokemon_species_names.KEY_name));
                name.genus = cursor.getString(cursor.getColumnIndex(pokemon_species_names.KEY_genus));
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return name;

    }


}
