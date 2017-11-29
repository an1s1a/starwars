package com.starwarsapp.detail;

import android.util.Log;

import com.starwarsapp.data.model.Film;
import com.starwarsapp.data.model.Planet;
import com.starwarsapp.data.model.Vehicle;
import com.starwarsapp.data.source.DataSource;
import com.starwarsapp.data.source.Repository;
import com.starwarsapp.data.source.remote.RemoteDataSource;

import java.util.ArrayList;
import java.util.List;

public class DetailPresenter implements DetailContract.Presenter{

    private static final String LOG_TAG = DetailPresenter.class.getSimpleName();


    private DetailContract.View view;
    private Repository repository;
    private List<Vehicle> vehicleList = new ArrayList<>();
    private List<Film> filmList = new ArrayList<>();
    private Planet planet = new Planet();

    public DetailPresenter(DetailContract.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadVehicle(String vehicleId){
        loadVehicleFromRepository(vehicleId);

    }

    private void loadVehicleFromRepository(String vehicleId){
        repository.getVehicle(vehicleId, new DataSource.LoadDataCallBack<Vehicle>() {
            @Override
            public void onDataLoaded(Object o) {
                vehicleList.add((Vehicle) o);
                view.showVehicles(vehicleList);
            }

            @Override
            public void onDataNotAvailable() {
                Log.e(LOG_TAG, "Data not available");
            }
        });
    }

    @Override
    public void loadWorld(String worldId) {
        loadWorldFromRepository(worldId);
    }

    private void loadWorldFromRepository(String worldId){
        repository.getPlanet(worldId, new RemoteDataSource.LoadDataCallBack<Planet>() {
            @Override
            public void onDataLoaded(Object o) {
                planet = (Planet) o;
                view.showPlanet(planet);
            }

            @Override
            public void onDataNotAvailable() {
                Log.e(LOG_TAG, "Data not available");

            }
        });
    }

    @Override
    public void loadFilm(String filmId) {
        loadFilmFromRepository(filmId);
    }

    private void loadFilmFromRepository(String filmId){
        repository.getFilm(filmId, new DataSource.LoadDataCallBack<Film>() {
            @Override
            public void onDataLoaded(Object o) {
                filmList.add((Film) o);
                view.showFilms(filmList);
            }

            @Override
            public void onDataNotAvailable() {
                Log.e(LOG_TAG, "Data not available");
            }
        });
    }
}
