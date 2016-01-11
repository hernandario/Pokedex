package com.example.hernan.pokedex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class note_adapter extends RecyclerView.Adapter<note_adapter.notesViewHolder> {

    private ArrayList<notas> lista_notas;

    public note_adapter(ArrayList<notas> lista_notas){
            this.lista_notas=lista_notas;

    }


    @Override
    public notesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        notesViewHolder nvh;

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_view_layout, parent, false);

        nvh = new notesViewHolder(itemView);

        return nvh;
    }

    @Override
    public void onBindViewHolder(notesViewHolder holder, int position) {

        notas n = lista_notas.get(position);

        holder.bindNote(n);
    }

    @Override
    public int getItemCount() {

        return lista_notas.size();
    }

    static class notesViewHolder extends  RecyclerView.ViewHolder{

        private TextView tvNoteText;
        private ImageButton btnEditNote, btnDeleteNote;

        public notesViewHolder(View itemView) {
            super(itemView);

            tvNoteText = (TextView) itemView.findViewById(R.id.tvNoteText);
            btnEditNote = (ImageButton) itemView.findViewById(R.id.btnEditNote);
            btnDeleteNote = (ImageButton) itemView.findViewById(R.id.btnDeleteNote);
        }

        public void bindNote(notas n){

            tvNoteText.setText(n.texto);

        }
    }
}
