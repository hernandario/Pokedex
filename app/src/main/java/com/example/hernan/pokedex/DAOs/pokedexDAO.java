package com.example.hernan.pokedex.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokedex;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokedexDAO {

    private DBHelper dbHelper;

    public pokedexDAO(Context context) {

        dbHelper = new DBHelper(context);
    }

    public void insert(int pokedex_id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(pokedex.KEY_id, pokedex_id);
        long id = db.insert(pokedex.TABLE, null, values);

        db.close();

    }

    public pokedex getPkedexById(int pokedex_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT "
                + pokedex.KEY_id
                + " FROM " + pokedex.TABLE
                + " WHERE " + " = ?";

        int iCount = 0;
        pokedex dex = new pokedex();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(pokedex_id)});

        if(cursor.moveToFirst()){
            do{
                dex.id = cursor.getInt(cursor.getColumnIndex(pokedex.KEY_id));
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return dex;
    }
}
