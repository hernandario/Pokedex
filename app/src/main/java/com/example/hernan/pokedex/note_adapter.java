package com.example.hernan.pokedex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hernan.pokedex.DAOs.notasDAO;
import com.example.hernan.pokedex.classes.notas;

import java.util.ArrayList;

/**
 * Created by Hernan on 10/1/16.
 */
public class note_adapter extends RecyclerView.Adapter<note_adapter.notesViewHolder> implements View.OnClickListener{

    private ArrayList<notas> lista_notas;
    private View.OnClickListener listener;

    public note_adapter(ArrayList<notas> lista_notas){
            this.lista_notas=lista_notas;

    }


    @Override
    public notesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        notesViewHolder nvh;

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_view_layout, parent, false);
        itemView.setOnClickListener(this);

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

    public void addNote(notas n){

        lista_notas.add(n);

        notifyItemInserted(lista_notas.size());

    }

    public static void editNote(notas n, String text){

    }

    public void setOnClcikListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

        if(listener != null)
            listener.onClick(v);

    }

    static class notesViewHolder extends  RecyclerView.ViewHolder{

        private EditText tvNoteText;
        private ImageButton btnEditNote, btnDeleteNote;

        public notesViewHolder(View itemView) {
            super(itemView);

            tvNoteText = (EditText) itemView.findViewById(R.id.tvNoteText);


        }

        public void bindNote(notas nota){

            final notas n = nota;

            tvNoteText.setText(n.texto);
            tvNoteText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    n.texto = String.valueOf(tvNoteText.getText());
                    notasDAO nDAO = new notasDAO(itemView.getContext());
                    nDAO.update(n);

                }
            });

        }
    }
}
