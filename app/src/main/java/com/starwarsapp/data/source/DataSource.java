package com.starwarsapp.data.source;

import java.util.List;

public interface DataSource {

    interface LoadDataListCallBack<T> {

        void onDataLoaded(List<T> list);

        void onDataNotAvailable();
    }

    interface LoadDataCallBack<T> {
        void onDataLoaded(Object o);

        void onDataNotAvailable();
    }

    void getPeoples(LoadDataListCallBack callBack, int page);

    void savePeoples();

    void deletePeoples();

    void getPeople(String peopleId, LoadDataCallBack callBack);

    void getPlanets(LoadDataListCallBack callBack);

    void savePlanets();

    void deletePlanets();

    void getPlanet(String planetId, LoadDataCallBack callBack);


    void getVehicles(LoadDataListCallBack callBack);

    void saveVehicles();

    void deleteVehicles();

    void getVehicle(String vehicleId, LoadDataCallBack callBack);


    void getFilms(LoadDataListCallBack callBack);

    void saveFilms();

    void deleteFilms();

    void getFilm(String filmId, LoadDataCallBack callBack);

}
