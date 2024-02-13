package com.vedruna.mproyectofinalsegundotrimestre.model;

import androidx.annotation.NonNull;
public class Movie {

    private int movieId;
    private String title;
    private String director;
    private String genre;
    private String imageUrl;

    public Movie() {
    }

    public Movie(String title, String director, String genre, String imageUrl) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Override
    public String toString() {
        return "Id: " + getMovieId() + " / Título: " + getTitle() + " / Director: " + getDirector() + " / Género: " + getGenre();
    }
}
