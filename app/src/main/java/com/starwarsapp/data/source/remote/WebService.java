package com.starwarsapp.data.source.remote;

import com.starwarsapp.data.model.BaseList;
import com.starwarsapp.data.model.Film;
import com.starwarsapp.data.model.People;
import com.starwarsapp.data.model.Planet;
import com.starwarsapp.data.model.Vehicle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {

    @GET("films")
    Callback<BaseList<Film>> getAllFilms();

    @GET("films/{id}/")
    public Call<Film> getFilm(@Path("id") int filmId);

    @GET("people")
    Call<BaseList<People>> getAllPeople(@Query("page") int page);

    @GET("people/{id}/")
    public Call<People> getPeople(@Path("id") int peopleId);

    @GET("planets/")
    public Call<BaseList<Planet>> getAllPlanets(@Query("page") int page);

    @GET("planets/{id}/")
    public Call<Planet> getPlanet(@Path("id") int planetId);


    @GET("vehicles/")
    public Call<BaseList<Vehicle>> getAllVehicles(@Query("page") int page);

    @GET("vehicles/{id}/")
    public Call<Vehicle> getVehicle(@Path("id") int vehicleId);

}
