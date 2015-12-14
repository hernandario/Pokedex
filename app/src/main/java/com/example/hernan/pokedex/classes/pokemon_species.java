package com.example.hernan.pokedex.classes;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_species {

    public static final String TABLE = "pokemon_species";

    public static final String KEY_id = "id";
    public static final String KEY_identifier = "identifier";
    public static final String KEY_generation = "generation";
    public static final String KEY_evolver_from_species_id = "evolves_from_species_id";
    public static final String KEY_evolution_chain_id = "evolution_chain_id";
    public static final String KEY_color_id = "color_id";
    public static final String KEY_shape_id = "shape_id";
    public static final String KEY_habitat_id = "habitat_id";
    public static final String KEY_gender_rate = "gender_rate";
    public static final String KEY_capture_rate = "capture_rate";
    public static final String KEY_base_happiness = "base_happiness";
    public static final String KEY_is_baby = "is_baby";
    public static final String KEY_hatch_counter = "hatch_counter";
    public static final String KEY_has_gender_differences = "has_gender_differences";
    public static final String KEY_growth_rate_id = "growth_rate_id";
    public static final String KEY_forms_switchable = "forms_switchable";
    public static final String KEY_order = "order";
    public static final String KEY_conquest_order = "conquest_order";


    public int id;
    public String identifier;
    public int generation_id;
    public int evolves_from_species_id;
    public int evolution_chain_id;
    public int color_id;
    public int dhape_id;
    public int habitat_id;
    public int gender_rate;
    public int capture_rate;
    public int base_happiness;
    public boolean is_baby;
    public int hatch_counter;
    public boolean has_gender_differences;
    public int growth_rate_id;
    public boolean forms_switchable;
    public int order;
}
