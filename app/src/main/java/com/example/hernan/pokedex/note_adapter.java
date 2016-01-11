package com.example.hernan.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

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

        View item = convertView;
        ViewHolder holder;

        if( item == null){

            LayoutInflater inflador = LayoutInflater.from(getContext());
            item = inflador.inflate(R.layout.notes_view_layout, null);

            holder = new ViewHolder();

            holder.tvNoteText = (TextView) item.findViewById(R.id.tvNoteText);
            holder.btnEditNote = (ImageButton) item.findViewById(R.id.btnEditNote);
            holder.btnDeleteNote = (ImageButton) item.findViewById(R.id.btnDeleteNote);

            item.setTag(holder);

        }

        else
            holder = (ViewHolder) item.getTag();

        holder.tvNoteText.setText(super.getItem(position).texto);

        return item;
    }


    static class ViewHolder{

        TextView tvNoteText;
        ImageButton btnEditNote, btnDeleteNote;

    }
}
