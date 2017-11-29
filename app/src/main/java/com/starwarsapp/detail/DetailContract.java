package com.starwarsapp.detail;

import com.starwarsapp.BasePresenter;
import com.starwarsapp.BaseView;
import com.starwarsapp.data.model.Film;
import com.starwarsapp.data.model.Planet;
import com.starwarsapp.data.model.Vehicle;

import java.util.List;

public interface DetailContract {

    interface View extends BaseView<Presenter> {
        void showVehicles(List<Vehicle> vehicles);
        void showFilms(List<Film> filmList);
        void showPlanet(Planet planet);
    }

    interface Presenter extends BasePresenter {
        void loadWorld(String worldId);
        void loadVehicle(String vehicleId);
        void loadFilm(String filmId);
    }
}
