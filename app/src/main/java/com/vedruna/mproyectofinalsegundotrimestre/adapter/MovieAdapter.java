package com.vedruna.mproyectofinalsegundotrimestre.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vedruna.mproyectofinalsegundotrimestre.R;
import com.vedruna.mproyectofinalsegundotrimestre.model.Movie;

import java.util.List;

/**
 * Adaptador personalizado para mostrar una lista de películas.
 */
public class MovieAdapter extends BaseAdapter {
    private List<Movie> movieList;
    private Context context;

    /**
     * Constructor para crear un adaptador de películas.
     *
     * @param context   Contexto de la aplicación.
     * @param movieList Lista de películas a mostrar.
     */
    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return movieList.get(position).getMovieId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.idLabel = convertView.findViewById(R.id.idLabel);
            viewHolder.idText = convertView.findViewById(R.id.idText);
            viewHolder.titleLabel = convertView.findViewById(R.id.titleLabel);
            viewHolder.titleText = convertView.findViewById(R.id.titleText);
            viewHolder.directorLabel = convertView.findViewById(R.id.directorLabel);
            viewHolder.directorText = convertView.findViewById(R.id.directorText);
            viewHolder.genreLabel = convertView.findViewById(R.id.genreLabel);
            viewHolder.genreText = convertView.findViewById(R.id.genreText);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Obtén la película actual
        Movie movie = (Movie) getItem(position);

        // Asignar los valores de la película a las vistas
        viewHolder.idLabel.setText("Id: ");
        viewHolder.idText.setText(String.valueOf(movie.getMovieId()));
        viewHolder.titleLabel.setText("Título: ");
        viewHolder.titleText.setText(movie.getTitle());
        viewHolder.directorLabel.setText("Director: ");
        viewHolder.directorText.setText(movie.getDirector());
        viewHolder.genreLabel.setText("Género: ");
        viewHolder.genreText.setText(movie.getGenre());
        Picasso.get().load(movie.getImageUrl()).into(viewHolder.imageView);

        return convertView;
    }

    /**
     * Clase ViewHolder para almacenar las vistas de cada elemento de la lista.
     */
    static class ViewHolder {
        TextView idLabel;
        TextView idText;
        TextView titleLabel;
        TextView titleText;
        TextView directorLabel;
        TextView directorText;
        TextView genreLabel;
        TextView genreText;
        ImageView imageView;
    }
}
