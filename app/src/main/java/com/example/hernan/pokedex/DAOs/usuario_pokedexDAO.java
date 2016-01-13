package com.example.hernan.pokedex.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.usuario_pokedex;

/**
 * Created by Hernan on 14/12/15.
 */
public class usuario_pokedexDAO {

    private DBHelper dbHelper;

    public usuario_pokedexDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public void insert(int usuario_id, int pokedex_id){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(usuario_pokedex.KEY_usuario_id, usuario_id);
        values.put(usuario_pokedex.KEY_pokedex_id, pokedex_id);

        long id = db.insert(usuario_pokedex.TABLE, null, values);

        db.close();

    }

    public usuario_pokedex getUsuario_pokedexById(int usuario_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT "
                + usuario_pokedex.KEY_usuario_id + ", "
                + usuario_pokedex.KEY_pokedex_id
                + " FROM " + usuario_pokedex.TABLE
                + " WHERE " + usuario_pokedex.KEY_usuario_id + " = ?";

        usuario_pokedex up = new usuario_pokedex();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(usuario_id)});

        if(cursor.moveToFirst()){
            do{
                up.usuario_id = cursor.getInt(cursor.getColumnIndex(usuario_pokedex.KEY_usuario_id));
                up.pokedex_id = cursor.getInt(cursor.getColumnIndex(usuario_pokedex.KEY_pokedex_id));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return up;
    }
}
