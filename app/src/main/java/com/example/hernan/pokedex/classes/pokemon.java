package com.example.hernan.pokedex.classes;

import java.io.Serializable;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon implements Serializable {

    public static final String TABLE = "pokemon";

    public static final String KEY_id = "id";
    public static final String KEY_identifier = "identifier";
    public static final String KEY_species_id = "species_id";
    public static final String KEY_height = "height";
    public static final String KEY_weight = "weight";
    public static final String KEY_base_experience = "base_experience";
    public static final String KEY_order = "orden";
    public static final String KEY_is_default = "is_default";

    public int id;
    public String identifier;
    public int species_id;
    public int height;
    public int weight;
    public int base_experience;
    public int order;
    public boolean is_default;

}
