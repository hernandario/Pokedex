package com.example.hernan.pokedex.DAOs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hernan.pokedex.DBHelper;
import com.example.hernan.pokedex.classes.pokemon_species;

import java.util.ArrayList;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_speciesDAO {

    private DBHelper dbHelper;

    public pokemon_speciesDAO(Context context){

        dbHelper = new DBHelper(context);

    }

    public ArrayList<pokemon_species> getPokemons(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT "
                + pokemon_species.KEY_id + ", "
                + pokemon_species.KEY_identifier + ", "
                + pokemon_species.KEY_generation + ", "
                + pokemon_species.KEY_evolver_from_species_id + ", "
                + pokemon_species.KEY_evolution_chain_id + ", "
                + pokemon_species.KEY_color_id + ", "
                + pokemon_species.KEY_shape_id + ", "
                + pokemon_species.KEY_habitat_id + ", "
                + pokemon_species.KEY_gender_rate + ", "
                + pokemon_species.KEY_capture_rate + ", "
                + pokemon_species.KEY_base_happiness + ", "
                + pokemon_species.KEY_is_baby + ", "
                + pokemon_species.KEY_hatch_counter + ", "
                + pokemon_species.KEY_has_gender_differences + ", "
                + pokemon_species.KEY_growth_rate_id + ", "
                + pokemon_species.KEY_forms_switchable + ", "
                + pokemon_species.KEY_order + ", "
                + pokemon_species.KEY_conquest_order
                + " FROM " + pokemon_species.TABLE;

        ArrayList<pokemon_species> pokemons = new ArrayList<pokemon_species>();

        Cursor cursor = db.rawQuery(selectQuery, new String[] {});

        if(cursor.moveToFirst()){
            do{
                pokemon_species ps = new pokemon_species();

                ps.id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.identifier = cursor.getString(cursor.getColumnIndex(pokemon_species.KEY_identifier));
                ps.generation_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_generation));
                ps.evolves_from_species_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_evolver_from_species_id));
                ps.evolution_chain_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_evolution_chain_id));
                ps.color_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.shape_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.habitat_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.gender_rate = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.capture_rate = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.base_happiness = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.is_baby = (cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id)) == 1)? true : false;
                ps.hatch_counter = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.has_gender_differences = (cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id)) == 1)? true : false;
                ps.growth_rate_id = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.forms_switchable = (cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id)) == 1)? true : false;
                ps.order = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));
                ps.conquest_order = cursor.getInt(cursor.getColumnIndex(pokemon_species.KEY_id));

                pokemons.add(ps);


            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return pokemons;

    }
}
