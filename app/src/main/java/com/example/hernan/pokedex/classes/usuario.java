package com.example.hernan.pokedex.classes;

import java.io.Serializable;

/**
 * Created by Hernan on 14/12/15.
 */
public class usuario implements Serializable {

    public static final String TABLE = "usuario";

    public static final String KEY_id = "id";
    public static final String KEY_nombre = "nombre";
    public static final String KEY_mail = "mail";
    public static final String KEY_local_language_id = "local_language_id";

    public int id;
    public String nombre;
    public String mail;
    public int local_language_id;

}
