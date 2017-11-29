package com.starwarsapp.people;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PeopleViewModule {

    @Binds
    abstract PeopleContract.View providePeopleView(PeopleActivity peopleActivity);

}
