package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokemon_species_flavor_text;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_species_flavor_textDAO {

    private DBHelper dbHelper;

    public pokemon_species_flavor_textDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public String getDescription(int species_id, int language_id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT "
                + pokemon_species_flavor_text.KEY_flavor_text
                + " FROM " + pokemon_species_flavor_text.TABLE
                + " WHERE " + pokemon_species_flavor_text.KEY_species_id + " = ?"
                + " AND " + pokemon_species_flavor_text.KEY_language_id + " = ?";

        String description = "";

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(species_id), String.valueOf(language_id)});

        if(cursor.moveToFirst()){
            do{
                description = cursor.getString(cursor.getColumnIndex(pokemon_species_flavor_text.KEY_flavor_text));
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return description;
    }
}
