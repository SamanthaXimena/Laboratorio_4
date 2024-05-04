package com.example.laboratorio_4.AppActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Adapter.GeolocalizacionAdapter;
import com.example.laboratorio_4.Data.GeolocalizacionData;
import com.example.laboratorio_4.R;

import java.util.ArrayList;
import java.util.List;

public class GeolocalizacionActivity extends AppCompatActivity {

    private GeolocalizacionAdapter adapter;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_geo);

        recyclerView = findViewById(R.id.recycler_view_geo);

        List<GeolocalizacionData> data_List = new ArrayList<>();
        data_List.add(new GeolocalizacionData("Nombre de sitio 1"));
        data_List.add(new GeolocalizacionData("Nombre de sitio 2"));
        data_List.add(new GeolocalizacionData("Nombre de sitio 3"));
        data_List.add(new GeolocalizacionData("Nombre de sitio 4"));
        data_List.add(new GeolocalizacionData("Nombre de sitio 5"));
        data_List.add(new GeolocalizacionData("Nombre de sitio 6"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GeolocalizacionAdapter(data_List);
        recyclerView.setAdapter(adapter);

    }


}
