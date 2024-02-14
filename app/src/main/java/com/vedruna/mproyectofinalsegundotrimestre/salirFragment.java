package com.vedruna.mproyectofinalsegundotrimestre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * Fragmento utilizado para mostrar una pantalla de confirmación de salida.
 */
public class salirFragment extends Fragment {

    /**
     * Constructor público vacío requerido por el sistema.
     */
    public salirFragment() {
    }

    /**
     * Método llamado para crear la vista asociada al fragmento.
     *
     * @param inflater           El LayoutInflater utilizado para inflar el diseño.
     * @param container          El ViewGroup al que se añadirá la vista inflada.
     * @param savedInstanceState La instancia previamente guardada del fragmento.
     * @return La vista inflada para el fragmento.
     */
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
