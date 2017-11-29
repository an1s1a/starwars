package com.starwarsapp.di;

import com.starwarsapp.data.source.Repository;
import com.starwarsapp.data.source.local.LocalDataSource;
import com.starwarsapp.data.source.remote.ApiConstants;
import com.starwarsapp.data.source.remote.RemoteDataSource;
import com.starwarsapp.data.source.remote.RequestInterceptor;
import com.starwarsapp.data.source.remote.WebService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttplClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(ApiConstants.TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    WebService provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(WebService.class);
    }

    @Provides
    @Singleton
    Repository provideRepository(WebService webService){
        return Repository.getInstance(RemoteDataSource.getInstance(webService),
                LocalDataSource.getInstance(null));
    }

}
