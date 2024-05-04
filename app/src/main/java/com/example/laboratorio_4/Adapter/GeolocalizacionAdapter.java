package com.example.laboratorio_4.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Data.GeolocalizacionData;
import com.example.laboratorio_4.R;

import java.util.List;

public class GeolocalizacionAdapter extends RecyclerView.Adapter<GeolocalizacionAdapter.ViewHolder> {

    private List<GeolocalizacionData> geolocalizacionData_List;



    public GeolocalizacionAdapter(List<GeolocalizacionData> geolocalizacionData_List ) {
        this.geolocalizacionData_List = geolocalizacionData_List;

    }

    @NonNull
    @Override
    public GeolocalizacionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_geolocalizacion_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeolocalizacionAdapter.ViewHolder holder, int position) {
        GeolocalizacionData geolocalizacion_Data = geolocalizacionData_List.get(position);
        holder.nombre_ciudad_geo.setText(geolocalizacion_Data.getNombre_ciudad_geo());
    }

    @Override
    public int getItemCount() {return geolocalizacionData_List.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre_ciudad_geo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_ciudad_geo= itemView.findViewById(R.id.nombre_ciudad_geo);

        }
    }
}
