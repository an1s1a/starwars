package com.starwarsapp.people;

import com.starwarsapp.data.source.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PeopleModule {

    @Provides
    PeoplePresenter providePeoplePresenter(PeopleContract.View peopleView, Repository repository){
        return new PeoplePresenter(peopleView, repository);
    }
}
