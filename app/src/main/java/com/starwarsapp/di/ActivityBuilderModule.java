package com.starwarsapp.di;

import com.starwarsapp.people.PeopleActivity;
import com.starwarsapp.detail.DetailActivity;
import com.starwarsapp.detail.DetailModule;
import com.starwarsapp.detail.DetailViewModule;
import com.starwarsapp.people.PeopleModule;
import com.starwarsapp.people.PeopleViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {PeopleViewModule.class, PeopleModule.class} )
    abstract PeopleActivity mainActivity();

    @ContributesAndroidInjector(modules = {DetailViewModule.class, DetailModule.class})
    abstract DetailActivity detailActivity();
}
