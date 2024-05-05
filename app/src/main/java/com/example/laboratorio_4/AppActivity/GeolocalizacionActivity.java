package com.example.laboratorio_4.AppActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Adapter.GeolocalizacionAdapter;
import com.example.laboratorio_4.R;
import com.example.laboratorio_4.databinding.ActivityMainBinding;

public class GeolocalizacionActivity extends AppCompatActivity {

    private GeolocalizacionAdapter adapter;
    private RecyclerView recyclerView;
    ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_geolocalizacion);
        recyclerView = findViewById(R.id.recycler_view_geo);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


}
