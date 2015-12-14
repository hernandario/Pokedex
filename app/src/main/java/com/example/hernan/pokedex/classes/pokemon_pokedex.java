package com.example.hernan.pokedex.classes;

/**
 * Created by Hernan on 14/12/15.
 */
public class pokemon_pokedex {

    public static final String TABLE = "pokemon_pokedex";

    public static final String KEY_species_id = "species_id";
    public static final String KEY_pokedex_id = "pokedex_id";
    public static final String KEY_visto = "visto";
    public static final String KEY_capturado = "capturado";

    public int species_id;
    public int pokedex_id;
    public boolean visto;
    public boolean capturado;

}
