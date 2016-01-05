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
                +")";

        String LANGAGUE = "CREATE TABLE "
                + languages.TABLE + "("
                +")";

        String NOTAS = "CREATE TABLE "
                + notas.TABLE + "("
                +")";

        String POKEDEX = "CREATE TABLE "
                + pokedex.TABLE + "("
                +")";

        String POKEMON_COLORS = "CREATE TABLE "
                + pokemon_colors.TABLE + "("
                +")";

        String POKEMON_POKEDEX = "CREATE TABLE "
                + pokemon_pokedex.TABLE + "("
                +")";

        String POKEMON_SPECIES_FLAVOR_TEXT = "CREATE TABLE "
                + pokemon_species_flavor_text.TABLE + "("
                +")";

        String POKEMON_SPECIES_NAMES = "CREATE TABLE "
                + pokemon_species_names.TABLE + "("
                +")";

        String POKEMON_SPECIES = "CREATE TABLE "
                + pokemon_species.TABLE + "("
                +")";

        String POKEMON = "CREATE TABLE "
                + pokemon.TABLE + "("
                +")";

        String REGIONS = "CREATE TABLE "
                + regions.TABLE + "("
                +")";

        String TYPES_NAMES = "CREATE TABLE "
                + types_names.TABLE + "("
                +")";

        String TYPES = "CREATE TABLE "
                + types.TABLE + "("
                +")";

        String USUARIO_POKEDEX = "CREATE TABLE "
                + usuario_pokedex.TABLE + "("
                +")";

        String VERSION_GROUPS = "CREATE TABLE "
                + version_groups.TABLE + "("
                +")";

        String VERSIONS = "CREATE TABLE "
                + versions.TABLE + "("
                +")";

        String USUARIOS   = "CREATE TABLE "
                + usuario.TABLE + "("
                +")";

    }

    public void execute_create(SQLiteDatabase db, String create_table){



    }
}
