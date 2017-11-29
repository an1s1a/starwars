package com.starwarsapp.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.starwarsapp.R;
import com.starwarsapp.data.model.Film;
import com.starwarsapp.data.model.People;
import com.starwarsapp.data.model.Planet;
import com.starwarsapp.data.model.Vehicle;
import com.starwarsapp.data.source.Repository;
import com.starwarsapp.utils.SWConstants;
import com.starwarsapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class DetailActivity extends AppCompatActivity implements DetailContract.View{

    @BindView(R.id.text_personal_info)
    TextView personalInfo;

    @BindView(R.id.character_born)
    TextView characterBorn;

    @BindView(R.id.character_gender)
    TextView characterGender;

    @BindView(R.id.character_hair)
    TextView characterHair;

    @BindView(R.id.character_skin)
    TextView characterSkin;

    @BindView(R.id.character_height)
    TextView characterHeight;

    @BindView(R.id.character_homeworld)
    TextView characterHomeworld;

    @BindView(R.id.recycler_view_vehicle)
    RecyclerView recyclerViewVehicles;

    @BindView(R.id.text_vehicles_info)
    TextView textVehiclesInfo;

    @BindView(R.id.divider_vehicles)
    View vehiclesDivider;

    @BindView(R.id.recycler_view_film)
    RecyclerView recyclerViewFilm;

    @Inject
    DetailPresenter presenter;
    @Inject
    Repository repository;

    private static final String LOG_TAG = DetailActivity.class.getSimpleName();

    private LinearLayoutManager layoutManager;
    private DetailVehiclesAdapter vehiclesAdapter;
    private DetailFilmsAdapter filmsAdapter;

    public static Intent newIntent(Context context, People people){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(SWConstants.KEY_PEOPLE_ID, (Parcelable) people);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);
        ButterKnife.bind(this);
        People people = getIntent().getParcelableExtra(SWConstants.KEY_PEOPLE_ID);
        String world = Utils.trimUrl(people.homeWorldUrl);
        initHomeWorld(world);
        initVehicleList(people);
        initFilmList(people);
        personalInfo.setText(people.name);
        characterBorn.setText(people.birthYear);
        characterGender.setText(people.gender);
        characterHair.setText(people.hairColor);
        characterSkin.setText(people.skinColor);
        characterHeight.setText(people.height);
        initVehiclesRecycler();
        initFilmRecycler();
    }

    private void initHomeWorld(String worldId){
        presenter.loadWorld(worldId);
    }

    private void initVehicleList(People people) {
        int vehiclesListSize = people.getVehiclesUrls().size();
        for(int i = 0; i < vehiclesListSize; i++){
            String vehicleIndex = Utils.trimUrl(people.getVehiclesUrls().get(i));
            presenter.loadVehicle(vehicleIndex);
        }
        if(vehiclesListSize == 0){
            recyclerViewVehicles.setVisibility(View.GONE);
            vehiclesDivider.setVisibility(View.GONE);
            textVehiclesInfo.setVisibility(View.GONE);
        }
    }

    private void initFilmList(People people){
        int filmListSize = people.getFilmsUrls().size();
        for(int i = 0; i < filmListSize; i++){
            String filmIndex = Utils.trimUrl(people.getFilmsUrls().get(i));
            presenter.loadFilm(filmIndex);
        }
    }


    private void initVehiclesRecycler() {
        layoutManager = new LinearLayoutManager(this);
        recyclerViewVehicles.setLayoutManager(layoutManager);
        vehiclesAdapter = new DetailVehiclesAdapter(presenter, new ArrayList<Vehicle>());
        recyclerViewVehicles.setAdapter(vehiclesAdapter);
    }

    private void initFilmRecycler(){
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFilm.setLayoutManager(layoutManager);
        filmsAdapter = new DetailFilmsAdapter(presenter, new ArrayList<Film>());
        recyclerViewFilm.setAdapter(filmsAdapter);
    }

    @Override
    public void showVehicles(List<Vehicle> vehicles) {
        vehiclesAdapter.setData(vehicles);
    }

    @Override
    public void showFilms(List<Film> filmList) {
        filmsAdapter.setData(filmList);
    }

    @Override
    public void showPlanet(Planet planet) {
        characterHomeworld.setText(planet.name);
    }

}
