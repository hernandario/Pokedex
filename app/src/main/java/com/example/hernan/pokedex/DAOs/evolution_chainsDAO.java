package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.evolution_chains;

/**
 * Created by Hernan on 14/12/15.
 */
public class evolution_chainsDAO {

    private DBHelper dbHelper;

    public evolution_chainsDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public evolution_chains getEvolution_chainsByID(int Id){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT "
                + evolution_chains.KEY_id + ", "
                + evolution_chains.KEY_baby_trigger_item_id
                + "FROM " + evolution_chains.TABLE
                + "WHERE " + evolution_chains.KEY_id
                + "= ?";


        int iCount = 0;
        evolution_chains ev_chain = new evolution_chains();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {String.valueOf(Id)});

        if(cursor.moveToFirst()){
            do{

                ev_chain.id = cursor.getInt(cursor.getColumnIndex(evolution_chains.KEY_id));
                ev_chain.baby_trigger_id = cursor.getInt(cursor.getColumnIndex(evolution_chains.KEY_baby_trigger_item_id));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return ev_chain;


    }
}
