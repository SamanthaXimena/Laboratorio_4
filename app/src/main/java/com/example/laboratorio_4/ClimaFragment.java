package com.example.laboratorio_4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laboratorio_4.Adapter.ClimaAdapter;
import com.example.laboratorio_4.Data.ClimaData;
import com.example.laboratorio_4.databinding.FragmentClimaBinding;

import java.util.ArrayList;
import java.util.List;


public class ClimaFragment extends Fragment {

    FragmentClimaBinding binding;

    RecyclerView recyclerView;
    List<ClimaData> data_List;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentClimaBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        binding.buttonToGeolocalizacion.setOnClickListener(v -> {

            NavController navController = NavHostFragment.findNavController(ClimaFragment.this);
            navController.navigate(R.id.action_climaFragment_to_geolocalizacionFragment);
        });

        recyclerView = view.findViewById(R.id.recycler_view_clima);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));

        data_List = new ArrayList<>();

        data_List.add(new ClimaData("Clima 1"));
        data_List.add(new ClimaData("Clima 2"));
        data_List.add(new ClimaData("Clima 3"));
        data_List.add(new ClimaData("Clima 4"));
        data_List.add(new ClimaData("Clima 5"));
        data_List.add(new ClimaData("Clima 6"));

        recyclerView.setAdapter(new ClimaAdapter(data_List));

        //return binding.getRoot();
        return view;

    }
}