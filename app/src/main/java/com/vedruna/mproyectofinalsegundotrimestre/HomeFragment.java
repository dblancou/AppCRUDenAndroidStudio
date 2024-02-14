package com.vedruna.mproyectofinalsegundotrimestre;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.vedruna.mproyectofinalsegundotrimestre.adapter.MovieAdapter;
import com.vedruna.mproyectofinalsegundotrimestre.interfaces.CRUDInterfaces;
import com.vedruna.mproyectofinalsegundotrimestre.model.Movie;
import com.vedruna.mproyectofinalsegundotrimestre.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Fragmento para mostrar la lista de películas.
 */
public class HomeFragment extends Fragment {

    private List<Movie> movies;
    private CRUDInterfaces crudInterface;
    private ListView listView;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Obtener la referencia del ListView
        listView = view.findViewById(R.id.lista);

        // Obtener todas las películas y cargarlas en el ListView
        getAllMovies();

        return view;
    }

    /**
     * Método para obtener todas las películas de la API y mostrarlas en el ListView.
     */
    private void getAllMovies() {
        // Configurar Retrofit para realizar la llamada a la API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear una instancia de la interfaz de la API
        crudInterface = retrofit.create(CRUDInterfaces.class);

        // Llamar al método que obtiene todas las películas
        Call<List<Movie>> call = crudInterface.getAll();

        // Manejar la respuesta de la llamada
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(@NonNull Call<List<Movie>> call, @NonNull Response<List<Movie>> response) {
                if (!response.isSuccessful()) {
                    // Si la respuesta no fue exitosa, imprimir el mensaje de error
                    Log.e("Reponse error: ", response.message());
                    return;
                }

                // Si la respuesta fue exitosa, obtener la lista de películas
                movies = response.body();

                // Crear un adaptador para las películas y asignarlo al ListView
                MovieAdapter movieAdapter = new MovieAdapter(requireContext(), movies);
                listView.setAdapter(movieAdapter);

                // Imprimir las películas en el registro para fines de depuración
                Log.i("Películas:", movies.toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Movie>> call, @NonNull Throwable t) {
                // Manejar los errores de la llamada
                Log.e("throw error: ", t.getMessage());
            }
        });
    }
}
