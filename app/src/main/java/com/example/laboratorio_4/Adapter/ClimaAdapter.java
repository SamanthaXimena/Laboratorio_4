package com.example.laboratorio_4.Adapter;

import android.content.Context;
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
    Context context;


    public ClimaAdapter(Context context, List<ClimaData> climaData_List ) {
        this.climaData_List = climaData_List;
        this.context = context;
    }

    @NonNull
    @Override
    public ClimaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_clima_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClimaAdapter.ViewHolder holder, int position) {
        ClimaData clima= climaData_List.get(position);
        holder.nombre_ciudad_clima.setText(clima.getNombre_ciudad_clima());
        holder.info_viento.setText(clima.getInfo_viento());
        holder.num_min.setText(String.valueOf(clima.getNum_min()));
        holder.num_max.setText(String.valueOf(clima.getNum_max()));
        holder.num_en_k.setText(String.valueOf(clima.getNum_en_k()));
    }

    @Override
    public int getItemCount() {return climaData_List.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre_ciudad_clima, info_viento,num_min, num_max,  num_en_k;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_ciudad_clima= itemView.findViewById(R.id.nombre_ciudad_clima);
            info_viento= itemView.findViewById(R.id.info_viento);
            num_min= itemView.findViewById(R.id.num_min);
            num_max= itemView.findViewById(R.id.num_max);
            num_en_k= itemView.findViewById(R.id.num_en_k);


        }
    }
}


