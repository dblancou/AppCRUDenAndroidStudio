package com.vedruna.mproyectofinalsegundotrimestre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class salirFragment extends Fragment {

    public salirFragment() {
        // Constructor público vacío requerido por el sistema
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño para este fragmento
        View view = inflater.inflate(R.layout.fragment_salir, container, false);

        // Obtener la referencia del botón
        Button botonSalir = view.findViewById(R.id.botonSalir);

        // Configurar OnClickListener para el botón
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la aplicación
                getActivity().finish();
            }
        });

        return view;
    }
}