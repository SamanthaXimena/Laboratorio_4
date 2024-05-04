package com.example.laboratorio_4.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laboratorio_4.Data.ClimaData;
import com.example.laboratorio_4.R;

import java.util.List;

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ViewHolder> {


    private List<ClimaData> climaData_List;



    public ClimaAdapter(List<ClimaData> climaData_List ) {
        this.climaData_List = climaData_List;

    }

    @NonNull
    @Override
    public ClimaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_clima_item, parent, false);
        return new ClimaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimaAdapter.ViewHolder holder, int position) {
        ClimaData clima_Data = climaData_List.get(position);
        holder.nombre_ciudad_clima.setText(clima_Data.getNombre_ciudad_clima());
    }

    @Override
    public int getItemCount() {return climaData_List.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre_ciudad_clima;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_ciudad_clima= itemView.findViewById(R.id.nombre_ciudad_clima);

        }
    }
}


