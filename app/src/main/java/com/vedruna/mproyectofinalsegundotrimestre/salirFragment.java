package com.vedruna.mproyectofinalsegundotrimestre;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Fragmento utilizado para mostrar una pantalla de confirmación de salida.
 */
public class salirFragment extends Fragment {

    private Button btnCerrarSesion;
    private GoogleSignInClient googleSignInClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salir, container, false);

        // Inicialización del botón
        btnCerrarSesion = view.findViewById(R.id.botonSalir);

        // Configuración de Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);

        // Configuración del listener del botón
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarSesion();
            }
        });

        return view;
    }


    /**
     * Método para cerrar la sesión del usuario.
     */
    private void cerrarSesion() {
        FirebaseAuth.getInstance().signOut(); // Cierra la sesión de Firebase

        // Cierra la sesión de Google
        googleSignInClient.signOut().addOnCompleteListener(getActivity(),
                task -> {
                    // Redirige a la actividad de inicio de sesión
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish(); // Cierra la actividad actual para que no se pueda volver atrás
                    showToast("Sesión cerrada");

                });
    }

    /**
     * Método para mostrar un mensaje Toast.
     *
     * @param message El mensaje a mostrar.
     */
    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}