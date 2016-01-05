package com.example.hernan.pokedex;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

        createTables(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createTables(SQLiteDatabase db){


        String EVOLUTION_CHAINS = "CREATE TABLE "
                + evolution_chains.TABLE + "("
                + evolution_chains.KEY_id + "INTEGER, "
                + evolution_chains.KEY_baby_trigger_item_id + "INTEGER"
                +")";

        execute_create(db, EVOLUTION_CHAINS);


        String GENERATIONS = "CREATE TABLE "
                + generations.TABLE + "("
                + generations.KEY_id + "INTEGER, "
                + generations.KEY_main_region_id + "INTEGER, "
                + generations.KEY_identifier + "VARCHAR"
                +")";

        execute_create(db, GENERATIONS);

        String LANGAGUE = "CREATE TABLE "
                + languages.TABLE + "("
                + languages.KEY_id + "INTEGER, "
                + languages.KEY_iso639 + "VARCHAR, "
                + languages.KEY_iso3166 + "VARCHAR, "
                + languages.KEY_identifier + "VARCHAR, "
                + languages.KEY_official + "BOOLEAN, "
                + languages.KEY_order + "INTEGER"
                +")";

        execute_create(db, LANGAGUE);

        String NOTAS = "CREATE TABLE "
                + notas.TABLE + "("
                +")";

        execute_create(db, NOTAS);

        String POKEDEX = "CREATE TABLE "
                + pokedex.TABLE + "("
                +")";

        execute_create(db, POKEDEX);

        String POKEMON_COLORS = "CREATE TABLE "
                + pokemon_colors.TABLE + "("
                +")";

        execute_create(db, POKEMON_COLORS);

        String POKEMON_POKEDEX = "CREATE TABLE "
                + pokemon_pokedex.TABLE + "("
                +")";

        execute_create(db, POKEMON_POKEDEX);

        String POKEMON_SPECIES_FLAVOR_TEXT = "CREATE TABLE "
                + pokemon_species_flavor_text.TABLE + "("
                +")";

        execute_create(db, POKEMON_SPECIES_FLAVOR_TEXT);

        String POKEMON_SPECIES_NAMES = "CREATE TABLE "
                + pokemon_species_names.TABLE + "("
                +")";

        execute_create(db, POKEMON_SPECIES_NAMES);

        String POKEMON_SPECIES = "CREATE TABLE "
                + pokemon_species.TABLE + "("
                +")";

        execute_create(db, POKEMON_SPECIES);

        String POKEMON = "CREATE TABLE "
                + pokemon.TABLE + "("
                +")";

        execute_create(db, POKEMON);

        String REGIONS = "CREATE TABLE "
                + regions.TABLE + "("
                +")";

        execute_create(db, REGIONS);

        String TYPES_NAMES = "CREATE TABLE "
                + types_names.TABLE + "("
                +")";

        execute_create(db, TYPES_NAMES);

        String TYPES = "CREATE TABLE "
                + types.TABLE + "("
                +")";

        execute_create(db, TYPES);

        String USUARIO_POKEDEX = "CREATE TABLE "
                + usuario_pokedex.TABLE + "("
                +")";

        execute_create(db, USUARIO_POKEDEX);

        String VERSION_GROUPS = "CREATE TABLE "
                + version_groups.TABLE + "("
                +")";

        execute_create(db, VERSION_GROUPS);

        String VERSIONS = "CREATE TABLE "
                + versions.TABLE + "("
                +")";

        execute_create(db, VERSIONS);

        String USUARIOS   = "CREATE TABLE "
                + usuario.TABLE + "("
                +")";

        execute_create(db, USUARIOS);

    }

    public void execute_create(SQLiteDatabase db, String create_table){

        db.execSQL(create_table);

    }
}
