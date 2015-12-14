package com.example.hernan.pokedex.classes;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_species_flavor_text {

    public static final String TABLE = "pokemon_species_flavor_text";

    public static final String KEY_species_id = "species_id";
    public static final String KEY_version_id = "version_id";
    public static final String KEY_language_id = "language_id";
    public static final String KEY_flavor_text = "flavor_text";

    public int species_id;
    public int version_id;
    public int language_id;
    public String flavor_text;


}
