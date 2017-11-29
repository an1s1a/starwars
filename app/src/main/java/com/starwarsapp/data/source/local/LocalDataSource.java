package com.starwarsapp.data.source.local;

import android.content.ContentResolver;

import com.starwarsapp.data.source.DataSource;

public class LocalDataSource implements DataSource {

    private static LocalDataSource INSTANCE;

    private ContentResolver contentResolver;

    private LocalDataSource(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public static LocalDataSource getInstance(ContentResolver contentResolver) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(contentResolver);
        }
        return INSTANCE;
    }

    @Override
    public void getPeoples(LoadDataListCallBack callBack, int page) {

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

    }
}
