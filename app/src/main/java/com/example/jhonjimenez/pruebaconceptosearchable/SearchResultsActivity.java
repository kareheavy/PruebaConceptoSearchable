package com.example.jhonjimenez.pruebaconceptosearchable;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecycler adapterRecycler;
    private List<String> listaResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        getComponentsUI();

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }

    }

    private void getComponentsUI() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void doMySearch(String query) {

        List<String> lista = new ArrayList<>();
        lista.add("motorola");
        lista.add("samsung");
        lista.add("apple");
        lista.add("xiaomi");
        lista.add("sony");
        lista.add("nokia");
        lista.add("moto G");


        for(String object: lista){
            if(object.contains(query)){
                listaResult.add(object);
            }
        }

        adapterRecycler = new AdapterRecycler(this, listaResult);
        recyclerView.setAdapter(adapterRecycler);
    }
}
