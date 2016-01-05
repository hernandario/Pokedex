package com.example.hernan.pokedex;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hernan on 14/12/15.
 */
public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 0;
    private static final String DATABASE_NAME = "pokedex.db";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        createTables();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createTables(){


        String EVOLUTION_CHAINS = "CREATE TABLE ";

        String GENERATIONS;

        String LANGAGUE;

        String NOTAS;

        String POKEDEX;

        String POKEMON_COLORS;

        String POKEMON_POKEDEX;

        String POKEMON_SPECIES_FLAVOR_TEXT;

        String POKEMON_SPECIES_NAMES;

        String POKEMON_SPECIES;

        String POKEMON;

        String REGIONS;

        String TYPES_NAMES;

        String TYPES;

        String USUARIO_POKEDEX;

        String VERSION_GROUPS;

        String VERSIONS;

        String USUARIOS;






    }
}
