package com.vedruna.mproyectofinalsegundotrimestre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.vedruna.mproyectofinalsegundotrimestre.interfaces.CRUDInterfaces;
import com.vedruna.mproyectofinalsegundotrimestre.model.Movie;
import com.vedruna.mproyectofinalsegundotrimestre.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Fragmento para crear una nueva película.
 */
public class CrearFragment extends Fragment {

    EditText editTextTitulo;
    EditText editTextDirector;
    EditText editTextGenero;
    EditText editTextUrlPoster;
    Button buttonCrearPelicula;

    CRUDInterfaces crudInterfaces;

    public CrearFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_crear, container, false);

        // Inicializar los EditText
        editTextTitulo = rootView.findViewById(R.id.editTextTitulo);
        editTextDirector = rootView.findViewById(R.id.editTextDirector);
        editTextGenero = rootView.findViewById(R.id.editTextGenero);
        editTextUrlPoster = rootView.findViewById(R.id.editTextUrlPoster);

        // Inicializar el botón
        buttonCrearPelicula = rootView.findViewById(R.id.buttonCrearPelicula);

        // Agregar un listener al botón para manejar clics
        buttonCrearPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String titulo = editTextTitulo.getText().toString().trim();
                String director = editTextDirector.getText().toString().trim();
                String genero = editTextGenero.getText().toString().trim();
                String urlPoster = editTextUrlPoster.getText().toString().trim();

                // Verificar si algún campo está vacío
                if (titulo.isEmpty() || director.isEmpty() || genero.isEmpty() || urlPoster.isEmpty()) {
                    // Mostrar un mensaje de error si algún campo está vacío
                    Toast.makeText(getActivity(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear una instancia de la película con los datos ingresados
                    Movie movie = new Movie(titulo, director, genero, urlPoster);
                    // Llamar al método para crear la película
                    create(movie);
                }
            }
        });

        return rootView;
    }

    /**
     * Método para crear una nueva película.
     * @param movie La película a crear.
     */
    private void create(Movie movie) {
        // Configurar Retrofit para realizar la llamada a la API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear una instancia de la interfaz de la API
        crudInterfaces = retrofit.create(CRUDInterfaces.class);

        // Llamar al método que crea la película
        Call<Movie> call = crudInterfaces.create(movie);

        // Manejar la respuesta de la llamada
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                // Verificar si la llamada fue exitosa
                if (!response.isSuccessful()) {
                    // Mostrar un mensaje de error si la llamada no fue exitosa
                    Toast.makeText(getActivity(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                    return;
                }

                // Obtener la película creada
                Movie createdMovie = response.body();

                // Mostrar un mensaje de éxito con el título de la película creada
                mostrarToast("Película añadida correctamente: " + createdMovie.getTitle());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                // Manejar los errores de la llamada
                Toast.makeText(getActivity(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Método para mostrar un mensaje Toast.
     * @param mensaje El mensaje a mostrar.
     */
    private void mostrarToast(String mensaje) {
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
