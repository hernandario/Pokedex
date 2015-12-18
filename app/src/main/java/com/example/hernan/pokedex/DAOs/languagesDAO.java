package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.languages;

/**
 * Created by Hernan on 14/12/15.
 */
public class languagesDAO {

    private DBHelper dbHelper;

    public languagesDAO(Context context) {

        dbHelper = new DBHelper(context);

    }

    public languages getLanguageById(int language_id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT "
                +languages.KEY_id + ", "
                +languages.KEY_iso639 + ", "
                +languages.KEY_iso3166+ ", "
                +languages.KEY_identifier + ", "
                +languages.KEY_official + ", "
                +languages.KEY_order
                + " FROM " + languages.TABLE
                + " WHERE " + languages.KEY_id + " = ?";

        languages language = new languages();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(language_id)});

        if(cursor.moveToFirst()){
            do{

                language.id = cursor.getInt(cursor.getColumnIndex(languages.KEY_id));
                language.iso639 = cursor.getString(cursor.getColumnIndex(languages.KEY_iso639));
                language.iso3166 = cursor.getString(cursor.getColumnIndex(languages.KEY_iso3166));
                language.identifier = cursor.getString(cursor.getColumnIndex(languages.KEY_identifier));
                language.official = (cursor.getInt(cursor.getColumnIndex(languages.KEY_official)) == 1)? true : false ;
                language.order = cursor.getInt(cursor.getColumnIndex(languages.KEY_order));


            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return language;

    }
}
