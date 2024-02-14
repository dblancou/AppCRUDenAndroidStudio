package com.vedruna.mproyectofinalsegundotrimestre.model;

import androidx.annotation.NonNull;

/**
 * Clase que representa un objeto de película.
 */
public class Movie {

    private int movieId;
    private String title;
    private String director;
    private String genre;
    private String imageUrl;

    /**
     * Constructor sin argumentos.
     */
    public Movie() {
    }

    /**
     * Constructor con argumentos para inicializar una película.
     *
     * @param title    Título de la película.
     * @param director Director de la película.
     * @param genre    Género de la película.
     * @param imageUrl URL de la imagen de la película.
     */
    public Movie(String title, String director, String genre, String imageUrl) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    /**
     * Obtiene el ID de la película.
     *
     * @return ID de la película.
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Establece el ID de la película.
     *
     * @param movieId ID de la película.
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Obtiene el título de la película.
     *
     * @return Título de la película.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Establece el título de la película.
     *
     * @param title Título de la película.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtiene el director de la película.
     *
     * @return Director de la película.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece el director de la película.
     *
     * @param director Director de la película.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Obtiene el género de la película.
     *
     * @return Género de la película.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Establece el género de la película.
     *
     * @param genre Género de la película.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Obtiene la URL de la imagen de la película.
     *
     * @return URL de la imagen de la película.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Establece la URL de la imagen de la película.
     *
     * @param imageUrl URL de la imagen de la película.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Método que devuelve una representación en cadena de la película.
     *
     * @return Representación en cadena de la película.
     */
    @NonNull
    @Override
    public String toString() {
        return "Id: " + getMovieId() + " / Título: " + getTitle() + " / Director: " + getDirector() + " / Género: " + getGenre();
    }
}
