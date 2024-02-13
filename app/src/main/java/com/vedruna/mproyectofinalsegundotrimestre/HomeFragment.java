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


public class HomeFragment extends Fragment {

    private List<Movie> movies;
    private CRUDInterfaces crudInterface;
    private ListView listView;

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.lista);
        getAllMovies();
        return view;
    }

    private void getAllMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        crudInterface = retrofit.create(CRUDInterfaces.class);
        Call<List<Movie>> call = crudInterface.getAll();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(@NonNull Call<List<Movie>> call, @NonNull Response<List<Movie>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Reponse error: ", response.message());
                    return;
                }

                movies = response.body();
                MovieAdapter movieAdapter = new MovieAdapter(requireContext(), movies);
                listView.setAdapter(movieAdapter);
                Log.i("Películas:", movies.toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Movie>> call, @NonNull Throwable t) {
                Log.e("throw error: ", t.getMessage());
            }
        });
    }

}