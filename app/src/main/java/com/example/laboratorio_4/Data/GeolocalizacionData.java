package com.example.laboratorio_4.Data;

public class GeolocalizacionData {
     String state;
     Double lat, lon;


    public GeolocalizacionData(String state, Double lat, Double lon) {
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }



    public String getState() {
        return state;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
