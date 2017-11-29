package com.starwarsapp.data.source.remote;

import android.util.Log;

import com.starwarsapp.data.model.BaseList;
import com.starwarsapp.data.model.Film;
import com.starwarsapp.data.model.People;
import com.starwarsapp.data.model.Planet;
import com.starwarsapp.data.model.Vehicle;
import com.starwarsapp.data.source.DataSource;

import retrofit2.Call;
import retrofit2.Response;

public class RemoteDataSource implements DataSource {

    private static final String LOG_TAG = RemoteDataSource.class.getSimpleName();

    private static RemoteDataSource INSTANCE;
    private WebService service;

    public static RemoteDataSource getInstance(WebService service) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(service);
        }
        return INSTANCE;
    }

    private RemoteDataSource(WebService service) {
        this.service = service;
    }


    @Override
    public void getPeoples(final LoadDataListCallBack callBack, int page) {
        Call<BaseList<People>> peopleResponse = service.getAllPeople(page);
        peopleResponse.enqueue(new retrofit2.Callback<BaseList<People>>() {
            @Override
            public void onResponse(Call<BaseList<People>> call, Response<BaseList<People>> response) {
                if(response.body() != null && !response.body().getResults().isEmpty()){
                    callBack.onDataLoaded(response.body().getResults());
                } else {
                    callBack.onDataNotAvailable();
                    Log.e(LOG_TAG, "Data not available");
                }
            }

            @Override
            public void onFailure(Call<BaseList<People>> call, Throwable t) {
                Log.e(LOG_TAG, "Data not available");

            }
        });
    }

    @Override
    public void savePeoples() {

    }

    @Override
    public void deletePeoples() {

    }

    @Override
    public void getPeople(String peopleId, LoadDataCallBack callBack) {

    }

    @Override
    public void getPlanets(LoadDataListCallBack callBack) {

    }

    @Override
    public void savePlanets() {

    }

    @Override
    public void deletePlanets() {

    }

    @Override
    public void getPlanet(String planetId, LoadDataCallBack callBack) {
        Call<Planet> planetResponse = service.getPlanet(Integer.parseInt(planetId));
        planetResponse.enqueue(new retrofit2.Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                if(response.body() != null){
                    callBack.onDataLoaded(response.body());
                } else {
                    callBack.onDataNotAvailable();
                    Log.e(LOG_TAG, "Data not available");
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                Log.e(LOG_TAG, "Data not available");

            }
        });
    }

    @Override
    public void getVehicles(LoadDataListCallBack callBack) {

    }

    @Override
    public void saveVehicles() {

    }

    @Override
    public void deleteVehicles() {

    }

    @Override
    public void getVehicle(String vehicleId, LoadDataCallBack callBack) {
        Call<Vehicle> vehicleResponse = service.getVehicle(Integer.parseInt(vehicleId));
        vehicleResponse.enqueue(new retrofit2.Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                if(response.body() != null){
                    callBack.onDataLoaded(response.body());
                } else {
                    callBack.onDataNotAvailable();
                    Log.e(LOG_TAG, "Data not available");

                }
            }

            @Override
            public void onFailure(Call<Vehicle> call, Throwable t) {
                Log.e(LOG_TAG, "Data not available");
            }
        });
    }

    @Override
    public void getFilms(LoadDataListCallBack callBack) {

    }

    @Override
    public void saveFilms() {

    }

    @Override
    public void deleteFilms() {

    }

    @Override
    public void getFilm(String filmId, LoadDataCallBack callBack) {
        Call<Film> filmResponse = service.getFilm(Integer.parseInt(filmId));
        filmResponse.enqueue(new retrofit2.Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if(response.body() != null){
                    callBack.onDataLoaded(response.body());
                } else {
                    callBack.onDataNotAvailable();
                    Log.e(LOG_TAG, "Data not available");

                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.e(LOG_TAG, "Data not available");
            }
        });
    }
}
