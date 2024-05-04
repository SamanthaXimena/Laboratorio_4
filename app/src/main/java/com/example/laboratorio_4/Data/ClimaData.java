package com.example.laboratorio_4.Data;

import android.app.appsearch.PackageIdentifier;

public class ClimaData {
    private String nombre_ciudad_clima;
    private String num_min;
    private String num_max;
    private String num_en_k;
    private String info_viento;

    public String getNombre_ciudad_clima() {
        return nombre_ciudad_clima;
    }

    public String getNum_min() {
        return num_min;
    }

    public String getNum_max() {
        return num_max;
    }

    public String getNum_en_k() {
        return num_en_k;
    }

    public String getInfo_viento() {
        return info_viento;
    }

    public ClimaData(String nombre_ciudad_clima) {
        this.nombre_ciudad_clima = nombre_ciudad_clima;
    }
}
