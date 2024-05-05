package com.example.laboratorio_4.Data;

import android.app.appsearch.PackageIdentifier;

public class ClimaData {
    String nombre_ciudad_clima , info_viento;
    Double num_min,num_max, num_en_k ;

    public String getNombre_ciudad_clima() {
        return nombre_ciudad_clima;
    }

    public String getInfo_viento() {
        return info_viento;
    }

    public Double getNum_min() {
        return num_min;
    }

    public Double getNum_max() {
        return num_max;
    }

    public Double getNum_en_k() {
        return num_en_k;
    }

    public ClimaData(String nombre_ciudad_clima, String info_viento, Double num_min, Double num_max, Double num_en_k) {
        this.nombre_ciudad_clima = nombre_ciudad_clima;
        this.info_viento = info_viento;
        this.num_min = num_min;
        this.num_max = num_max;
        this.num_en_k = num_en_k;
    }
}
