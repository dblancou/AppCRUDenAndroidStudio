package com.vedruna.mproyectofinalsegundotrimestre.interfaces;

import com.vedruna.mproyectofinalsegundotrimestre.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interfaz que define las operaciones CRUD (Create, Read, Update, Delete) para las películas.
 */
public interface CRUDInterfaces {

    /**
     * Método para obtener todas las películas.
     *
     * @return Una lista de películas.
     */
    @GET("movie")
    Call<List<Movie>> getAll();

    /**
     * Método para obtener una película por su ID.
     *
     * @param id ID de la película.
     * @return La película con el ID especificado.
     */
    @GET("movie/{id}")
    Call<Movie> getMovie(@Path("id") int id);

    /**
     * Método para crear una nueva película.
     *
     * @param movie La película a crear.
     * @return La película creada.
     */
    @POST("movie")
    Call<Movie> create(@Body Movie movie);

    /**
     * Método para actualizar una película existente.
     *
     * @param id    ID de la película a actualizar.
     * @param movie La película actualizada.
     * @return La película actualizada.
     */
    @PUT("movie/{id}")
    Call<Movie> actualizar(@Path("id") int id, @Body Movie movie);

    /**
     * Método para eliminar una película por su ID.
     *
     * @param id ID de la película a eliminar.
     * @return Respuesta vacía.
     */
    @DELETE("movie/{id}")
    Call<Void> delete(@Path("id") int id);
}
