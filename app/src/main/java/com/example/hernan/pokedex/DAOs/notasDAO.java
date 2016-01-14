package com.example.hernan.pokedex.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.notas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hernan on 14/12/15.
 */
public class notasDAO {

    private DBHelper dbHelper;

    public notasDAO(Context context){
        dbHelper = new DBHelper((context));
    }

    public int insert(notas nota){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(notas.KEY_species_id, nota.species_id);
        values.put(notas.KEY_usuario_id, nota.usuario_id);
        values.put(notas.KEY_texto, nota.texto);

        long nota_id = db.insert(notas.TABLE, null, values);
        db.close();
        return (int) nota_id;

    }

    public void delete(int nota_id){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(notas.TABLE, notas.KEY_id + "= ?", new String[]{String.valueOf(nota_id)});
        db.close();

    }

    public void update(notas nota){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(notas.KEY_id, nota.id);
        values.put(notas.KEY_species_id, nota.species_id);
        values.put(notas.KEY_usuario_id, nota.usuario_id);
        values.put(notas.KEY_texto, nota.texto);

        db.update(notas.TABLE, values, notas.KEY_id + "= ?", new String[]{String.valueOf(nota.id)});
        db.close();

    }

    public ArrayList<notas> getListaNotasPokemon(int usuario_id, int species_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT "
                + notas.KEY_id + ", "
                + notas.KEY_species_id + ", "
                + notas.KEY_usuario_id + ", "
                + notas.KEY_texto
                + " FROM " + notas.TABLE
                + " WHERE " + notas.KEY_species_id + " = ?"
                + " AND "
                + notas.KEY_usuario_id + " = ?";

        ArrayList<notas> listaNotas = new ArrayList<notas>();

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(species_id), String.valueOf(usuario_id)});

        if(cursor.moveToFirst()){
            do{

                notas nota = new notas();

                nota.id = cursor.getInt(cursor.getColumnIndex(notas.KEY_id));
                nota.species_id = cursor.getInt(cursor.getColumnIndex(notas.KEY_species_id));
                nota.usuario_id = cursor.getInt(cursor.getColumnIndex(notas.KEY_usuario_id));
                nota.texto = cursor.getString(cursor.getColumnIndex(notas.KEY_texto));

                listaNotas.add(nota);

            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listaNotas;

    }

    public String getNotaById(int nota_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT "
                + notas.KEY_texto
                + " FROM " + notas.TABLE
                + " WHERE " + notas.KEY_id + " = ?";

        int iCount = 0;
        String contenidoNota = "";

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(nota_id)});

        if(cursor.moveToFirst()){
            do{

                contenidoNota = cursor.getString(cursor.getColumnIndex(notas.KEY_texto));

            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return contenidoNota;

    }


}
