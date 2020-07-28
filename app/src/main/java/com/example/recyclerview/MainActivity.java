package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExemploAdapter exemploAdapter;
    private List<Exemplo> listaExemplo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerExemplo);
    }

    public void carregamentoLista(){

        Exemplo exemplo1 = new Exemplo();
        exemplo1.setNomeExeplo("Exemplo 1");
        listaExemplo.add(exemplo1);

        Exemplo exemplo2 = new Exemplo();
        exemplo2.setNomeExeplo("Exemplo 2");
        listaExemplo.add(exemplo2);

        Exemplo exemplo3 = new Exemplo();
        exemplo3.setNomeExeplo("Rogério da Silva Castro Júnior");
        listaExemplo.add(exemplo3);

        Exemplo exemplo4 = new Exemplo();
        exemplo4.setNomeExeplo("Programação Android");
        listaExemplo.add(exemplo4);

        Exemplo exemplo5 = new Exemplo();
        exemplo5.setNomeExeplo("Viva la vida");
        listaExemplo.add(exemplo5);

        //configuração adapter

        exemploAdapter = new ExemploAdapter(listaExemplo);

        //configuracao Recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(exemploAdapter);

        //realização do click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Clique simples", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Clique longo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    //Necessario para recarregar o recycler devido a atualização de dados
    @Override
    protected void onStart() {
        carregamentoLista();
        super.onStart();
    }
}
