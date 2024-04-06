package com.example.projetopi4semestre.data.di;

import android.content.Context;

import com.example.projetopi4semestre.MyApplication;
import com.example.projetopi4semestre.data.remote.interceptor.TokenInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn({SingletonComponent.class})
public class NetworkModule {

    @Singleton
    @Provides
    public TokenInterceptor provideTokenInterceptor(){
        return new TokenInterceptor();
    }

    @Singleton
    @Provides
    public Gson provideGson(){ return new GsonBuilder().setLenient().create(); }

    @Singleton
    @Provides
    public Retrofit provideRetrofitInstance(TokenInterceptor tokenInterceptor, Gson gson){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(tokenInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(MyApplication.getApiUrl())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
