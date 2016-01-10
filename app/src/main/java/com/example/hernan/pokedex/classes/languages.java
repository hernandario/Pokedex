package com.example.hernan.pokedex.classes;

/**
 * Created by Hernan on 14/12/15.
 */
public class languages {

    public static final String TABLE = "languages";

    public static final String KEY_id = "id";
    public static final String KEY_iso639 = "iso639";
    public static final String KEY_iso3166 = "iso3166";
    public static final String KEY_identifier = "identifier";
    public static final String KEY_official = "official";
    public static final String KEY_order = "\"order\"";

    public int id;
    public String iso639;
    public String iso3166;
    public String identifier;
    public boolean official;
    public int order;

}
