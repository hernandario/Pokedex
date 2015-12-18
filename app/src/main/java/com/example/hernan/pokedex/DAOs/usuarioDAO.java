package com.example.hernan.pokedex.DAOs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.usuario;

/**
 * Created by Hernan on 14/12/15.
 */
public class usuarioDAO {

    private DBHelper dbHelper;

    public usuarioDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public int insert(usuario u){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(usuario.KEY_id, u.id);
        values.put(usuario.KEY_nombre, u.nombre);
        values.put(usuario.KEY_mail, u.mail);
        values.put(usuario.KEY_local_language_id, u.local_language_id);

        long usuario_id = db.insert(usuario.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) usuario_id;

    }

    public usuario getUsuario(String email){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selectQuery = "SELECT "
                + usuario.KEY_id + ", "
                + usuario.KEY_nombre + ", "
                + usuario.KEY_mail + ", "
                + usuario.KEY_local_language_id
                + " FROM " + usuario.TABLE
                + " WHERE " + usuario.KEY_mail + " = ?";

        int iCount = 0;
        usuario u = new usuario();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {email});

        if(cursor.moveToFirst()){
            do{

                u.id = cursor.getInt(cursor.getColumnIndex(usuario.KEY_id));
                u.nombre = cursor.getString(cursor.getColumnIndex(usuario.KEY_nombre));
                u.mail = cursor.getString(cursor.getColumnIndex(usuario.KEY_mail));
                u.local_language_id = cursor.getInt(cursor.getColumnIndex(usuario.KEY_local_language_id));

            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return u;

    }

    public void updateLanguage(usuario u){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(usuario.KEY_id, u.id);
        values.put(usuario.KEY_nombre, u.nombre);
        values.put(usuario.KEY_mail, u.mail);
        values.put(usuario.KEY_local_language_id, u.local_language_id);

        db.update(usuario.TABLE, values, usuario.KEY_id + " = ?", new String[] {String.valueOf(u.id)});

    }
}
