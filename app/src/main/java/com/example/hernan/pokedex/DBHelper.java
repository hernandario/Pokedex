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
                + evolution_chains.KEY_id + "INTEGER NOT NULL, "
                + evolution_chains.KEY_baby_trigger_item_id + "INTEGER"
                +")";

        execute_create(db, EVOLUTION_CHAINS);


        String GENERATIONS = "CREATE TABLE "
                + generations.TABLE + "("
                + generations.KEY_id + "INTEGER NOT NULL, "
                + generations.KEY_main_region_id + "INTEGER, "
                + generations.KEY_identifier + "VARCHAR(79)"
                +")";

        execute_create(db, GENERATIONS);

        String LANGAGUE = "CREATE TABLE "
                + languages.TABLE + "("
                + languages.KEY_id + "INTEGER NOT NULL, "
                + languages.KEY_iso639 + "VARCHAR(79), "
                + languages.KEY_iso3166 + "VARCHAR(79), "
                + languages.KEY_identifier + "VARCHAR(79), "
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
                + pokemon_colors.KEY_id + " INTEGER, "
                + pokemon_colors.KEY_identifier + "VARCHAR(79)"
                +")";

        execute_create(db, POKEMON_COLORS);

        String POKEMON_POKEDEX = "CREATE TABLE "
                + pokemon_pokedex.TABLE + "("
                +")";

        execute_create(db, POKEMON_POKEDEX);

        String POKEMON_SPECIES_FLAVOR_TEXT = "CREATE TABLE "
                + pokemon_species_flavor_text.TABLE + "("
                + pokemon_species_flavor_text.KEY_species_id + "INTEGER NOT NULL, "
                + pokemon_species_flavor_text.KEY_version_id + "INTEGER NOT NULL, "
                + pokemon_species_flavor_text.KEY_language_id + "INTEGER NOT NULL, "
                + pokemon_species_flavor_text.KEY_flavor_text + "TEXT NOT NULL"
                +")";

        execute_create(db, POKEMON_SPECIES_FLAVOR_TEXT);

        String POKEMON_SPECIES_NAMES = "CREATE TABLE "
                + pokemon_species_names.TABLE + "("
                + pokemon_species_names.KEY_pokemon_species_id + "INTEGER NOT NULL, "
                + pokemon_species_names.KEY_local_language_id + "INTEGER NOT NULL, "
                + pokemon_species_names.KEY_name + "VARCHAR(79), "
                + pokemon_species_names.KEY_genus + "TEXT"
                +")";

        execute_create(db, POKEMON_SPECIES_NAMES);

        String POKEMON_SPECIES = "CREATE TABLE "
                + pokemon_species.TABLE + "("
                + pokemon_species.KEY_id + "INTEGER NOT NULL, "
                + pokemon_species.KEY_identifier + "VARCHAR(79) NOT NULL, "
                + pokemon_species.KEY_generation + "INTEGER, "
                + pokemon_species.KEY_evolver_from_species_id + "INTEGER, "
                + pokemon_species.KEY_evolution_chain_id + "INTEGER, "
                + pokemon_species.KEY_color_id + "INTEGER NOT NULL, "
                + pokemon_species.KEY_shape_id + "INTEGER NOT NULL, "
                + pokemon_species.KEY_habitat_id + "INTEGER, "
                + pokemon_species.KEY_gender_rate + "INTEGER NOT NULL, "
                + pokemon_species.KEY_capture_rate + "INTEGER NOT NULL, "
                + pokemon_species.KEY_base_happiness + "INTEGER NOT NULL, "
                + pokemon_species.KEY_is_baby + "BOOLEAN NOT NULL, "
                + pokemon_species.KEY_hatch_counter + "INTEGER NOT NULL, "
                + pokemon_species.KEY_has_gender_differences + "BOOLEAN NOT NULL, "
                + pokemon_species.KEY_growth_rate_id + "INTEGER NOT NULL, "
                + pokemon_species.KEY_forms_switchable + "BOOLEAN NOT NULL, "
                + pokemon_species.KEY_order + "INTEGER NOT NULL, "
                + pokemon_species.KEY_conquest_order + "INTEGER"
                +")";

        execute_create(db, POKEMON_SPECIES);

        String POKEMON = "CREATE TABLE "
                + pokemon.TABLE + "("
                + pokemon.KEY_id + "INTEGER NOT NULL, "
                + pokemon.KEY_identifier + "VARCHAR(79) NOT NULL, "
                + pokemon.KEY_species_id + "INTEGER, "
                + pokemon.KEY_height + "INTEGER NOT NULL, "
                + pokemon.KEY_weight + "INTEGER NOT NULL, "
                + pokemon.KEY_base_experience + "INTEGER NOT NULL, "
                + pokemon.KEY_order + "INTEGER, "
                + pokemon.KEY_is_default + "BOOLEAN NOT NULL"
                +")";

        execute_create(db, POKEMON);

        String REGIONS = "CREATE TABLE "
                + regions.TABLE + "("
                + regions.KEY_id + "INTEGER NOT NULL, "
                + regions.KEY_identifier + "VARCHAR(79) NOT NULL, "
                +")";

        execute_create(db, REGIONS);

        String TYPES_NAMES = "CREATE TABLE "
                + types_names.TABLE + "("
                + types_names.KEY_type_id + "INTEGER NOT NULL, "
                + types_names.KEY_local_language_id + "INTEGER NOT NULL, "
                + types_names.KEY_name + "VARCHAR(79) NOT NULL"
                +")";

        execute_create(db, TYPES_NAMES);

        String TYPES = "CREATE TABLE "
                + types.TABLE + "("
                + types.KEY_id + "INTEGER NOT NULL, "
                + types.KEY_identifier + "VARCHAR(79) NOT NULL, "
                + types.KEY_generation_id + "INTEGER NOT NULL, "
                + types.KEY_damage_class_id + "INTEGER"
                +")";

        execute_create(db, TYPES);

        String USUARIO_POKEDEX = "CREATE TABLE "
                + usuario_pokedex.TABLE + "("
                +")";

        execute_create(db, USUARIO_POKEDEX);

        String VERSION_GROUPS = "CREATE TABLE "
                + version_groups.TABLE + "("
                + version_groups.KEY_id + "INTEGER NOT NULL, "
                + version_groups.KEY_identifier + "VARCHAR(79) NOT NULL, "
                + version_groups.KEY_generation_id + "INTEGER NOT NULL, "
                + version_groups.KEY_order + "INTEGER"
                +")";

        execute_create(db, VERSION_GROUPS);

        String VERSIONS = "CREATE TABLE "
                + versions.TABLE + "("
                + versions.KEY_id + "INTEGER NOT NULL, "
                + versions.KEY_version_group_id + "INTEGER NOT NULL, "
                + versions.KEY_identifier + "VARCHAR(79)"
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
