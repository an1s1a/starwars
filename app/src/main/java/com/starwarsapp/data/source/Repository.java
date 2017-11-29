package com.starwarsapp.data.source;

import com.starwarsapp.data.model.People;

import java.util.List;

import dagger.Module;

@Module
public class Repository implements DataSource {

    private static Repository INSTANCE = null;

    private final DataSource remoteDataSource;
    private final DataSource localDataSource;

    public static Repository getInstance(DataSource remoteDataSource, DataSource localDataSource){
        if(INSTANCE == null){
            INSTANCE = new Repository(remoteDataSource, localDataSource);
        }

        return INSTANCE;
    }

    public Repository(DataSource remoteDataSource, DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }


    @Override
    public void getPeoples(LoadDataListCallBack callBack, int page) {
        remoteDataSource.getPeoples(new LoadDataListCallBack<People>() {
            @Override
            public void onDataLoaded(List<People> list) {

                callBack.onDataLoaded(list);
            }

            @Override
            public void onDataNotAvailable() {
                callBack.onDataNotAvailable();
            }
        }, page);

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
        remoteDataSource.getPlanet(planetId, new LoadDataCallBack() {
            @Override
            public void onDataLoaded(Object o) {
                callBack.onDataLoaded(o);
            }

            @Override
            public void onDataNotAvailable() {
                callBack.onDataNotAvailable();
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
        remoteDataSource.getVehicle(vehicleId, new LoadDataCallBack() {
            @Override
            public void onDataLoaded(Object o) {
                callBack.onDataLoaded(o);
            }

            @Override
            public void onDataNotAvailable() {
                callBack.onDataNotAvailable();
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
        remoteDataSource.getFilm(filmId, new LoadDataCallBack() {
            @Override
            public void onDataLoaded(Object o) {
                callBack.onDataLoaded(o);
            }

            @Override
            public void onDataNotAvailable() {
                callBack.onDataNotAvailable();
            }
        });
    }


}
