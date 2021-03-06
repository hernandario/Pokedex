package com.example.hernan.pokedex;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.hernan.pokedex.classes.evolution_chains;
import com.example.hernan.pokedex.classes.generations;
import com.example.hernan.pokedex.classes.languages;
import com.example.hernan.pokedex.classes.notas;
import com.example.hernan.pokedex.classes.pokedex;
import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.pokemon_colors;
import com.example.hernan.pokedex.classes.pokemon_pokedex;
import com.example.hernan.pokedex.classes.pokemon_species;
import com.example.hernan.pokedex.classes.pokemon_species_flavor_text;
import com.example.hernan.pokedex.classes.pokemon_species_names;
import com.example.hernan.pokedex.classes.regions;
import com.example.hernan.pokedex.classes.types;
import com.example.hernan.pokedex.classes.types_names;
import com.example.hernan.pokedex.classes.usuario;
import com.example.hernan.pokedex.classes.usuario_pokedex;
import com.example.hernan.pokedex.classes.version_groups;
import com.example.hernan.pokedex.classes.versions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Hernan on 14/12/15.
 */
public class DBHelper extends SQLiteOpenHelper {


    private Context context;
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "pokedex.db";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        createTables(db);

        insertOnTables(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + evolution_chains.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + generations.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + languages.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + notas.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokedex.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokemon.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokemon_colors.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokemon_pokedex.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokemon_species.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokemon_species_flavor_text.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + pokemon_species_names.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + regions.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + types.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + types_names.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + usuario.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + usuario_pokedex.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + version_groups.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + versions.TABLE);

        // Create tables again
        onCreate(db);
    }

    public void createTables(SQLiteDatabase db){

        String EVOLUTION_CHAINS = "CREATE TABLE "
                + evolution_chains.TABLE + "("
                + evolution_chains.KEY_id + " INTEGER NOT NULL, "
                + evolution_chains.KEY_baby_trigger_item_id + " INTEGER"
                +")";

        db.execSQL(EVOLUTION_CHAINS);


        String GENERATIONS = "CREATE TABLE "
                + generations.TABLE + "("
                + generations.KEY_id + " INTEGER NOT NULL, "
                + generations.KEY_main_region_id + " INTEGER, "
                + generations.KEY_identifier + " VARCHAR(79)"
                +")";

        db.execSQL(GENERATIONS);

        String LANGAGUE = "CREATE TABLE "
                + languages.TABLE + "("
                + languages.KEY_id + " INTEGER NOT NULL, "
                + languages.KEY_iso639 + " VARCHAR(79), "
                + languages.KEY_iso3166 + " VARCHAR(79), "
                + languages.KEY_identifier + " VARCHAR(79), "
                + languages.KEY_official + " BOOLEAN, "
                + languages.KEY_order + " INTEGER"
                +")";

        db.execSQL(LANGAGUE);

        String NOTAS = "CREATE TABLE "
                + notas.TABLE + "("
                + notas.KEY_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + notas.KEY_usuario_id + " INTEGER NOT NULL, "
                + notas.KEY_species_id + " INTEGER NOT NULL, "
                + notas.KEY_texto + " TEXT"
                +")";

        db.execSQL(NOTAS);

        String POKEDEX = "CREATE TABLE "
                + pokedex.TABLE + "("
                + pokedex.KEY_id + " INTEGER PRIMARY KEY"
                +")";

        db.execSQL(POKEDEX);

        String POKEMON_COLORS = "CREATE TABLE "
                + pokemon_colors.TABLE + "("
                + pokemon_colors.KEY_id + " INTEGER, "
                + pokemon_colors.KEY_identifier + " VARCHAR(79)"
                +")";

        db.execSQL(POKEMON_COLORS);

        String POKEMON_POKEDEX = "CREATE TABLE "
                + pokemon_pokedex.TABLE + "("
                + pokemon_pokedex.KEY_species_id + " INTEGER NOT NULL, "
                + pokemon_pokedex.KEY_pokedex_id + " INTEGER NOT NULL, "
                + pokemon_pokedex.KEY_visto +  " BOOLEAN NOT NULL, "
                + pokemon_pokedex.KEY_capturado + " BOOLEAN "

                +")";

        db.execSQL(POKEMON_POKEDEX);

        String POKEMON_SPECIES_FLAVOR_TEXT = "CREATE TABLE "
                + pokemon_species_flavor_text.TABLE + "("
                + pokemon_species_flavor_text.KEY_species_id + " INTEGER NOT NULL, "
                + pokemon_species_flavor_text.KEY_version_id + " INTEGER NOT NULL, "
                + pokemon_species_flavor_text.KEY_language_id + " INTEGER NOT NULL, "
                + pokemon_species_flavor_text.KEY_flavor_text + " TEXT NOT NULL"
                +")";

        db.execSQL(POKEMON_SPECIES_FLAVOR_TEXT);

        String POKEMON_SPECIES_NAMES = "CREATE TABLE "
                + pokemon_species_names.TABLE + "("
                + pokemon_species_names.KEY_pokemon_species_id + " INTEGER NOT NULL, "
                + pokemon_species_names.KEY_local_language_id + " INTEGER NOT NULL, "
                + pokemon_species_names.KEY_name + " VARCHAR(79), "
                + pokemon_species_names.KEY_genus + " TEXT"
                +")";

        db.execSQL(POKEMON_SPECIES_NAMES);

        String POKEMON_SPECIES = "CREATE TABLE "
                + pokemon_species.TABLE + "("
                + pokemon_species.KEY_id + " INTEGER NOT NULL, "
                + pokemon_species.KEY_identifier + " VARCHAR(79) NOT NULL, "
                + pokemon_species.KEY_generation + " INTEGER, "
                + pokemon_species.KEY_evolver_from_species_id + " INTEGER, "
                + pokemon_species.KEY_evolution_chain_id + " INTEGER, "
                + pokemon_species.KEY_color_id +  " INTEGER NOT NULL, "
                + pokemon_species.KEY_shape_id + " INTEGER NOT NULL, "
                + pokemon_species.KEY_habitat_id + " INTEGER, "
                + pokemon_species.KEY_gender_rate + " INTEGER NOT NULL, "
                + pokemon_species.KEY_capture_rate + " INTEGER NOT NULL, "
                + pokemon_species.KEY_base_happiness + " INTEGER NOT NULL, "
                + pokemon_species.KEY_is_baby + " BOOLEAN NOT NULL, "
                + pokemon_species.KEY_hatch_counter + " INTEGER NOT NULL, "
                + pokemon_species.KEY_has_gender_differences + " BOOLEAN NOT NULL, "
                + pokemon_species.KEY_growth_rate_id + " INTEGER NOT NULL, "
                + pokemon_species.KEY_forms_switchable + " BOOLEAN NOT NULL, "
                + pokemon_species.KEY_order + " INTEGER NOT NULL, "
                + pokemon_species.KEY_conquest_order + " INTEGER"
                +")";

        db.execSQL(POKEMON_SPECIES);

        String POKEMON = "CREATE TABLE "
                + pokemon.TABLE + "("
                + pokemon.KEY_id + " INTEGER NOT NULL, "
                + pokemon.KEY_identifier + " VARCHAR(79) NOT NULL, "
                + pokemon.KEY_species_id + " INTEGER, "
                + pokemon.KEY_height + " INTEGER NOT NULL, "
                + pokemon.KEY_weight + " INTEGER NOT NULL, "
                + pokemon.KEY_base_experience + " INTEGER NOT NULL, "
                + pokemon.KEY_order + " INTEGER, "
                + pokemon.KEY_is_default + " BOOLEAN NOT NULL"
                +")";

        db.execSQL(POKEMON);

        String REGIONS = "CREATE TABLE "
                + regions.TABLE + "("
                + regions.KEY_id + " INTEGER NOT NULL, "
                + regions.KEY_identifier + " VARCHAR(79) NOT NULL "
                +")";

        db.execSQL(REGIONS);

        String TYPES_NAMES = "CREATE TABLE "
                + types_names.TABLE + "("
                + types_names.KEY_type_id + " INTEGER NOT NULL, "
                + types_names.KEY_local_language_id + " INTEGER NOT NULL, "
                + types_names.KEY_name + " VARCHAR(79) NOT NULL"
                +")";

        db.execSQL(TYPES_NAMES);

        String TYPES = "CREATE TABLE "
                + types.TABLE + "("
                + types.KEY_id + " INTEGER NOT NULL, "
                + types.KEY_identifier + " VARCHAR(79) NOT NULL, "
                + types.KEY_generation_id + " INTEGER NOT NULL, "
                + types.KEY_damage_class_id + " INTEGER"
                +")";

        db.execSQL(TYPES);

        String USUARIO_POKEDEX = "CREATE TABLE "
                + usuario_pokedex.TABLE + "("
                + usuario_pokedex.KEY_usuario_id + " INTEGER NOT NULL, "
                + usuario_pokedex.KEY_pokedex_id + " INTEGER NOT NULL"
                +")";

        db.execSQL(USUARIO_POKEDEX);

        String VERSION_GROUPS = "CREATE TABLE "
                + version_groups.TABLE + "("
                + version_groups.KEY_id + " INTEGER NOT NULL, "
                + version_groups.KEY_identifier + " VARCHAR(79) NOT NULL, "
                + version_groups.KEY_generation_id + " INTEGER NOT NULL, "
                + version_groups.KEY_order + " INTEGER"
                +")";

        db.execSQL(VERSION_GROUPS);

        String VERSIONS = "CREATE TABLE "
                + versions.TABLE + "("
                + versions.KEY_id + " INTEGER NOT NULL, "
                + versions.KEY_version_group_id + " INTEGER NOT NULL, "
                + versions.KEY_identifier + " VARCHAR(79)"
                +")";

        db.execSQL(VERSIONS);

        String USUARIOS   = "CREATE TABLE "
                + usuario.TABLE + "("
                + usuario.KEY_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + usuario.KEY_nombre + " VARCHAR(79), "
                + usuario.KEY_mail + " VARCHAR(79), "
                + usuario.KEY_local_language_id + " INTEGER NOT NULL"
                +")";

        db.execSQL(USUARIOS);

    }

    public void insertOnTables(SQLiteDatabase db){

        InputStream insertStream = context.getResources().openRawResource(R.raw.evolution_chains);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.generations);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.languages);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.pokemon);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.pokemon_colors);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.pokemon_species);
        executeInserts(db, insertStream);

        //insertStream = context.getResources().openRawResource(R.raw.pokemon_species_flavor_text);
        //executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.pokemon_species_names);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.regions);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.type_names);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.types);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.version_groups);
        executeInserts(db, insertStream);

        insertStream = context.getResources().openRawResource(R.raw.versions);
        executeInserts(db, insertStream);

    }

    public void executeInserts(SQLiteDatabase db, InputStream insertStream){

        int rowCount = 0;

        BufferedReader insertReader = new BufferedReader( new InputStreamReader(insertStream));

        try {
            while(insertReader.ready()){

                String insertStatement = insertReader.readLine();
                db.execSQL(insertStatement);

                rowCount ++;

            }

            insertReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
