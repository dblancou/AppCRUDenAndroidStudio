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
public interface CRUDInterfaces {

    @GET("movie")
    Call<List<Movie>> getAll();

    @GET("movie/{id}") // Método para obtener una película por su ID
    Call<Movie> getMovie(@Path("id") int id);

    @POST("movie")
    Call<Movie> create(@Body Movie movie);

    @PUT("movie/{id}")
    Call<Movie> actualizar(@Path("id") int id, @Body Movie movie);

    @DELETE("movie/{id}")
    Call<Void> delete(@Path("id") int id);
}