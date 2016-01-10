package com.example.hernan.pokedex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.hernan.pokedex.classes.notas;

import java.util.ArrayList;

/**
 * Created by Hernan on 10/1/16.
 */
public class note_adapter extends ArrayAdapter<notas> {

    public note_adapter(Context context, ArrayList<notas> lista_notas){
            super(context, R.layout.pokemon_view_layout, lista_notas);
            }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
            }


    static class ViewHolder{


    }
}
