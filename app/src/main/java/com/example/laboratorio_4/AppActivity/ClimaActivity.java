package com.example.laboratorio_4.AppActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Adapter.ClimaAdapter;
import com.example.laboratorio_4.Data.ClimaData;
import com.example.laboratorio_4.R;

import java.util.ArrayList;
import java.util.List;


public class ClimaActivity extends AppCompatActivity {
    private ClimaAdapter adapter;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_clim);

        recyclerView = findViewById(R.id.recycler_view_clima);

        List<ClimaData> data_List = new ArrayList<>();
        data_List.add(new ClimaData("Clima 1"));
        data_List.add(new ClimaData("Clima 2"));
        data_List.add(new ClimaData("Clima 3"));
        data_List.add(new ClimaData("Clima 4"));
        data_List.add(new ClimaData("Clima 5"));
        data_List.add(new ClimaData("Clima 6"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClimaAdapter(data_List);
        recyclerView.setAdapter(adapter);

    }


}