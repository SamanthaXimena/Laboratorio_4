package com.example.laboratorio_4.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Adapter.ClimaAdapter;
import com.example.laboratorio_4.R;
import com.example.laboratorio_4.databinding.ActivityMainBinding;


public class ClimaActivity extends AppCompatActivity {
    private ClimaAdapter adapter;
    private RecyclerView recyclerView;
    ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_clima);
        recyclerView = findViewById(R.id.recycler_view_clima);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }


}