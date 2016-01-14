package com.example.hernan.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hernan.pokedex.DAOs.notasDAO;
import com.example.hernan.pokedex.classes.notas;
import com.example.hernan.pokedex.classes.pokemon;
import com.example.hernan.pokedex.classes.pokemon_pokedex;
import com.example.hernan.pokedex.classes.usuario;

import java.util.ArrayList;

/**
 * Created by Hernan on 11/1/16.
 */
public class NotesActivity extends AppCompatActivity {


    private RecyclerView rvNotas;
    private ArrayList<notas> lista_notas;
    private android.support.design.widget.FloatingActionButton fbAgregar;
    private usuario u;
    private pokemon p;
    private notasDAO nDAO;
    private int position;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();
        inflador.inflate(R.menu.menu_borrar, menu);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_list_layout);

        u = (usuario) getIntent().getExtras().getSerializable(usuario.TABLE);
        p = (pokemon) getIntent().getExtras().getSerializable(pokemon.TABLE);

        nDAO = new notasDAO(NotesActivity.this);

        lista_notas =  nDAO.getListaNotasPokemon(u.id, p.species_id);

        rvNotas = (RecyclerView) findViewById(R.id.rvNotas);

        final note_adapter adaptador = new note_adapter(lista_notas);

        adaptador.setOnClcikListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerForContextMenu(v);

                position = rvNotas.getChildPosition(v);

                Toast.makeText(NotesActivity.this, "Hola", Toast.LENGTH_LONG).show();
            }
        });

        rvNotas.setAdapter(adaptador);
        rvNotas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        fbAgregar = (android.support.design.widget.FloatingActionButton) findViewById(R.id.fbAgregar);
        fbAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                notas n = new notas();
                n.species_id = p.species_id;
                n.usuario_id = u.id;
                nDAO.insert(n);

                adaptador.addNote(n);
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){

            case R.id.menu_borrar:
                nDAO.delete(lista_notas.get(position).id);

                Toast.makeText(NotesActivity.this, "Nota eliminada", Toast.LENGTH_LONG).show();

                Intent notas_intent = new Intent(NotesActivity.this, NotesActivity.class);
                notas_intent.putExtra(usuario.TABLE, u);
                notas_intent.putExtra(pokemon.TABLE, p);
                startActivity(notas_intent);

                break;


        }

        return super.onContextItemSelected(item);


    }

}
