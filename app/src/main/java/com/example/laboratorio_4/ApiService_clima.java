package com.example.laboratorio_4;

import com.example.laboratorio_4.Data.ClimaData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService_clima {

    @GET("data/2.5/weather")
    Call<List<ClimaData>> getData_clima(
            @Query("lat") double location,
            @Query("lon") double limit,
            @Query("appid") String apiKey
    );

    }
