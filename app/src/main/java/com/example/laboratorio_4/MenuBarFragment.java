package com.example.laboratorio_4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.laboratorio_4.Activity.ClimaActivity;
import com.example.laboratorio_4.Activity.GeolocalizacionActivity;

public class MenuBarFragment extends Fragment {

    private boolean isGeoSelected = false;
    private boolean isClimaSelected = false;


    private Button buttonGeo, buttonClima;
    private LinearLayout linearLayoutGeolocalizacion, layoutClima;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_bar_fragment, container, false);

        linearLayoutGeolocalizacion = view.findViewById(R.id.linearLayoutGeolocalizacion);
        layoutClima = view.findViewById(R.id.layoutClima);


        buttonGeo = view.findViewById(R.id.button_geo);
        buttonClima = view.findViewById(R.id.button_clima);



        configurarListeners();

        return view;
    }

    private void configurarListeners() {
        buttonGeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOptionClick(true, false);
            }
        });

        buttonClima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOptionClick(false, true);
            }
        });


    }

    private void handleOptionClick(boolean isGeo, boolean isClima) {
        resetOtherOptions();

        if (isGeo) {
            isGeoSelected = true;
            linearLayoutGeolocalizacion.setBackgroundColor(Color.parseColor("#3F2D40"));
            buttonGeo.setScaleX(0.8f);
            buttonGeo.setScaleY(0.8f);
            buttonGeo.setVisibility(View.VISIBLE);

            Intent intent = new Intent(getActivity(), GeolocalizacionActivity.class);
            startActivity(intent);
        }

        if (isClima) {
            isClimaSelected = true;
            layoutClima.setBackgroundColor(Color.parseColor("#3F2D40"));
            buttonClima.setScaleX(0.8f);
            buttonClima.setScaleY(0.8f);
            buttonClima.setVisibility(View.VISIBLE);

            Intent intent = new Intent(getActivity(), ClimaActivity.class);
            startActivity(intent);
        }
       }

    private void resetOtherOptions() {
        if (isGeoSelected) {
            isGeoSelected = false;
            linearLayoutGeolocalizacion.setBackgroundColor(Color.TRANSPARENT);
            buttonGeo.setScaleX(1.0f);
            buttonGeo.setScaleY(1.0f);

        }

        if (isClimaSelected) {
            isClimaSelected = false;
            layoutClima.setBackgroundColor(Color.TRANSPARENT);
            buttonClima.setScaleX(1.0f);
            buttonClima.setScaleY(1.0f);

        }




    }
}
