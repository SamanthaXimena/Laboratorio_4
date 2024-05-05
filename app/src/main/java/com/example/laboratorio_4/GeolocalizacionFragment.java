package com.example.laboratorio_4;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laboratorio_4.Adapter.GeolocalizacionAdapter;
import com.example.laboratorio_4.Data.GeolocalizacionData;
import com.example.laboratorio_4.databinding.FragmentGeolocalizacionBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GeolocalizacionFragment extends Fragment {

   FragmentGeolocalizacionBinding binding;
    private RecyclerView recyclerView;
    private List<GeolocalizacionData> geolocalizacionData_List = new ArrayList<>();
    private GeolocalizacionAdapter adapter;
    private ApiService_geo apiServiceGeo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGeolocalizacionBinding.inflate(inflater, container, false);

        View view = binding.getRoot();

        // Inicializar RecyclerView
        binding.recyclerViewGeo.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter= new GeolocalizacionAdapter(requireContext(), geolocalizacionData_List);
        binding.recyclerViewGeo.setAdapter(adapter);

        // Inicializar Retrofit y crear una instancia de la interfaz de servicio
        String baseUrl = "https://api.openweathermap.org/";

        apiServiceGeo = RetrofitClient.getClient(baseUrl).create(ApiService_geo.class);

        // Realizar la solicitud a la API
        String location = "Lima";
        int limit = 1;
        String apiKey = "8dd6fc3be19ceb8601c2c3e811c16cf1";

        Call<List<GeolocalizacionData>> call = apiServiceGeo.getData(location, limit, apiKey);
        call.enqueue(new Callback<List<GeolocalizacionData>>() {


            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<List<GeolocalizacionData>> call, Response<List<GeolocalizacionData>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    geolocalizacionData_List.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<GeolocalizacionData>> call, Throwable t) {

            }
        });
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

