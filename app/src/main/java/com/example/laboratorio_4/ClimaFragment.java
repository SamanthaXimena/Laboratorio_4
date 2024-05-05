package com.example.laboratorio_4;

import android.annotation.SuppressLint;
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

import com.example.laboratorio_4.Data.GeolocalizacionData;
import com.example.laboratorio_4.databinding.FragmentClimaBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ClimaFragment extends Fragment {

    private FragmentClimaBinding binding;
    private RecyclerView recyclerView;
    private List<ClimaData> climaData_List = new ArrayList<>();
    private ClimaAdapter adapter;
    private ApiService_clima apiServiceClima;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentClimaBinding.inflate(inflater , container, false);
        View view = binding.getRoot();
        // Inicializar RecyclerView
        binding.recyclerViewClima.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter= new ClimaAdapter(requireContext(), climaData_List);
        binding.recyclerViewClima.setAdapter(adapter);

        String baseUrl = "https://api.openweathermap.org/";

        apiServiceClima = ClimaFragment.RetrofitClient.getClient(baseUrl).create(ApiService_clima.class);

        // Realizar la solicitud a la API
        double lat = 44.34;
        double lon = 10.99;
        String apiKey = "792edf06f1f5ebcaf43632b55d8b03fe";

        Call<List<ClimaData>> call = apiServiceClima.getData_clima(lat, lon, apiKey);
        call.enqueue(new Callback<List<ClimaData>>() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<ClimaData>> call, Response<List<ClimaData>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    climaData_List.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ClimaData>> call, Throwable t) {

            }
        });




        //return binding.getRoot();
        return view;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public static class RetrofitClient {

        private static Retrofit retrofit = null;

        public static Retrofit getClient(String baseUrl) {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }
}