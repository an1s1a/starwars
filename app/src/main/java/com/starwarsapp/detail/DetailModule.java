package com.starwarsapp.detail;

import com.starwarsapp.data.source.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    @Provides
    DetailPresenter provideDetailPresenter(DetailContract.View detailView, Repository repository) {
        return new DetailPresenter(detailView, repository);
    }
}
