package com.vedruna.mproyectofinalsegundotrimestre;

import android.os.Bundle;
import android.util.Log;
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
 * Fragmento para la funcionalidad de borrado de películas.
 */
public class BorrarFragment extends Fragment {

    CRUDInterfaces crudInterfaces;
    Button button;
    EditText idEditText;

    public BorrarFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrar, container, false);

        // Inicializar el EditText para el ID
        idEditText = view.findViewById(R.id.editTextID);

        // Configurar el botón de borrado con el clic
        setupDeleteButton(view);

        return view;
    }

    /**
     * Configura el botón de borrado para manejar los clics.
     * @param view La vista del fragmento.
     */
    private void setupDeleteButton(View view) {
        button = view.findViewById(R.id.buttonBorrarProducto);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el ID ingresado por el usuario
                String idString = idEditText.getText().toString().trim();

                if (!idString.isEmpty()) {
                    int movieId = Integer.parseInt(idString);
                    checkAndDelete(movieId);
                } else {
                    // Manejar el caso en el que el ID esté vacío
                    // Puedes mostrar un mensaje de error o realizar otras acciones
                    Log.e("Error", "El ID no puede estar vacío");
                    mostrarToast("El ID no puede estar vacío");
                }
            }
        });
    }

    /**
     * Verifica la existencia de una película y la elimina si existe.
     * @param movieId El ID de la película a verificar y eliminar.
     */
    private void checkAndDelete(final int movieId) {
        // Construir la instancia de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear la interfaz CRUDInterface
        crudInterfaces = retrofit.create(CRUDInterfaces.class);

        // Realizar una solicitud de consulta para verificar si la película existe
        Call<Movie> call = crudInterfaces.getMovie(movieId);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Si la película existe, proceder con la eliminación
                    delete(movieId);
                } else {
                    // Si la película no existe, mostrar un mensaje de error
                    mostrarToast("La película con ID " + movieId + " no existe");
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                mostrarToast("La película no existe");
            }
        });
    }

    /**
     * Elimina una película de la base de datos utilizando su ID.
     * @param movieId El ID de la película a eliminar.
     */
    private void delete(int movieId) {
        // Llamar al método de borrado con el ID de la película
        Call<Void> call = crudInterfaces.delete(movieId);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Si la película se elimina correctamente
                    mostrarToast("Película eliminada");
                } else {
                    // Si ocurre un error al eliminar la película
                    Log.e("Response err ", response.message());
                    mostrarToast("Error al eliminar la película");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                mostrarToast("Error al eliminar la película");
            }
        });
    }

    /**
     * Muestra un mensaje Toast en la actividad actual.
     * @param mensaje El mensaje que se mostrará en el Toast.
     */
    private void mostrarToast(String mensaje) {
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
