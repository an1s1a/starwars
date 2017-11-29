package com.starwarsapp.detail;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DetailViewModule {

    @Binds
    abstract DetailContract.View provideDetailView(DetailActivity detailActivity);
}
