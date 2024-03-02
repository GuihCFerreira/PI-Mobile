package com.example.projetopi4semestre.data.di;

import com.example.projetopi4semestre.MyApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn({SingletonComponent.class})
public class NetworkModule {

    @Singleton
    @Provides
    public Gson provideGson(){ return new GsonBuilder().setLenient().create(); }

    @Singleton
    @Provides
    public Retrofit provideRetrofitInstance(Gson gson){
        return new Retrofit.Builder()
                .baseUrl(MyApplication.getApiUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
