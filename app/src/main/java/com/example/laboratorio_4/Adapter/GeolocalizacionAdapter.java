package com.example.laboratorio_4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Data.GeolocalizacionData;
import com.example.laboratorio_4.R;
import com.example.laboratorio_4.databinding.FragmentGeolocalizacionBinding;

import java.util.List;

public class GeolocalizacionAdapter extends RecyclerView.Adapter<GeolocalizacionAdapter.ViewHolder> {

    private List<GeolocalizacionData> geolocalizacionData_List;
    Context context;



    public GeolocalizacionAdapter(Context context ,List<GeolocalizacionData> geolocalizacionData_List) {
        this.context = context;
        this.geolocalizacionData_List = geolocalizacionData_List;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //FragmentGeolocalizacionBinding binding = FragmentGeolocalizacionBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        View view = LayoutInflater.from(context).inflate(R.layout.lista_geolocalizacion_item, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GeolocalizacionData geolocalizacion =geolocalizacionData_List.get(position);
        holder.state.setText(geolocalizacion.getState());
        holder.lat.setText(String.valueOf(geolocalizacion.getLat()));
        holder.lon.setText(String.valueOf(geolocalizacion.getLon()));
    }

    @Override
    public int getItemCount() {return geolocalizacionData_List.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lat, lon, state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lat= itemView.findViewById(R.id.lat);
            lon= itemView.findViewById(R.id.lon);
            state= itemView.findViewById(R.id.state);

        }

    }

}
