package com.example.laboratorio_4.Data;

public class GeolocalizacionData {
    private String nombre_ciudad_geo;
    private String latitud_ciudad;
    private String longitud_ciudad;

    public String getNombre_ciudad_geo() {
        return nombre_ciudad_geo;
    }

    public String getLatitud_ciudad() {
        return latitud_ciudad;
    }

    public String getLongitud_ciudad() {
        return longitud_ciudad;
    }

    public GeolocalizacionData(String nombre_ciudad_geo) {
        this.nombre_ciudad_geo = nombre_ciudad_geo;
    }
}
