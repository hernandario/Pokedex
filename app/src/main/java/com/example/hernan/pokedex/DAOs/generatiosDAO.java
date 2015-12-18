package com.example.hernan.pokedex.DAOs;

import android.content.Context;

import com.example.hernan.pokedex.DBHelper;

/**
 * Created by Hernan on 14/12/15.
 */
public class generatiosDAO {

    private DBHelper dbHelper;

    public generatiosDAO(Context context) {
        dbHelper = new DBHelper(context);
    }


}
