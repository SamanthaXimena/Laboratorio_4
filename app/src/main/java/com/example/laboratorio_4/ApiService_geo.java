package com.example.laboratorio_4;

import com.example.laboratorio_4.Data.GeolocalizacionData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService_geo {
    @GET("geo/1.0/direct")
    Call<List<GeolocalizacionData>> getData(
            @Query("q") String location,
            @Query("limit") int limit,
            @Query("appid") String apiKey
    );
}