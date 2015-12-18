package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokemon_colors;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_colorsDAO {

    private DBHelper dbHelper;

    public pokemon_colorsDAO(Context context) {

        dbHelper = new DBHelper(context);
    }

    public pokemon_colors getPkedexById(int color_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT "
                + pokemon_colors.KEY_id + ", "
                + pokemon_colors.KEY_identifier
                + " FROM " + pokemon_colors.TABLE
                + " WHERE " + " = ?";

        int iCount = 0;
        pokemon_colors color = new pokemon_colors();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(color_id)});

        if(cursor.moveToFirst()){
            do{
                color.id = cursor.getInt(cursor.getColumnIndex(pokemon_colors.KEY_id));
                color.identifier = cursor.getString(cursor.getColumnIndex(pokemon_colors.KEY_identifier));
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return color;
    }
}
