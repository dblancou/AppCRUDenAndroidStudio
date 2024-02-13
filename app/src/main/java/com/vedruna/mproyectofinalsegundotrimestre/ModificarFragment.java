package com.vedruna.mproyectofinalsegundotrimestre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vedruna.mproyectofinalsegundotrimestre.interfaces.CRUDInterfaces;
import com.vedruna.mproyectofinalsegundotrimestre.model.Movie;
import com.vedruna.mproyectofinalsegundotrimestre.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModificarFragment extends Fragment {

    EditText nameText;
    EditText posicionText;
    EditText equipoText;
    EditText editTextUrlImagen;
    Button button;
    EditText idText;  // Nuevo EditText para el ID

    private Retrofit retrofit;
    CRUDInterfaces crudInterfaces;

    public ModificarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_modificar, container, false);

        // Inicializar los EditText
        idText = rootView.findViewById(R.id.editTextID);  // Nuevo EditText para el ID
        nameText = rootView.findViewById(R.id.editTextTitulo);
        posicionText = rootView.findViewById(R.id.editTextDirector);
        equipoText = rootView.findViewById(R.id.editTextGenero);
        editTextUrlImagen = rootView.findViewById(R.id.editTextUrlPoster);

        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inicializar el botón
        button = rootView.findViewById(R.id.buttonActualizarPelicula);

        // Puedes agregar un listener al botón si deseas manejar clics
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si los campos están vacíos antes de actualizar
                if (validarCampos()) {
                    actualizar();
                } else {
                    mostrarToast("Por favor, completa todos los campos.");
                }
            }
        });

        return rootView;
    }

    private boolean validarCampos() {
        String id = idText.getText().toString().trim();
        String titulo = nameText.getText().toString().trim();
        String director = posicionText.getText().toString().trim();
        String genero = equipoText.getText().toString().trim();
        String urlImagen = editTextUrlImagen.getText().toString().trim();

        return !TextUtils.isEmpty(id) && !TextUtils.isEmpty(titulo) &&
                !TextUtils.isEmpty(director) && !TextUtils.isEmpty(genero) &&
                !TextUtils.isEmpty(urlImagen);
    }

    private void actualizar() {
        String id = idText.getText().toString().trim();
        String titulo = nameText.getText().toString().trim();
        String director = posicionText.getText().toString().trim();
        String genero = equipoText.getText().toString().trim();
        String urlImagen = editTextUrlImagen.getText().toString().trim();

        // Crear una película
        Movie movie = new Movie(titulo, director, genero, urlImagen);

        crudInterfaces = retrofit.create(CRUDInterfaces.class);

        // Llamar al método actualizar
        Call<Movie> call = crudInterfaces.actualizar(Integer.parseInt(id), movie);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err ", response.message());
                    return;
                }
                Movie movie1 = response.body();
                // Hacer algo con la película actualizada si es necesario
                mostrarToast("Película actualizada: " + movie1.getTitle());

            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                mostrarToast("Error al actualizar la película");
            }
        });
    }
    // Método para mostrar un Toast
    private void mostrarToast(String mensaje) {
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
