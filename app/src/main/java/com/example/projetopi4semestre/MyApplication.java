package com.example.projetopi4semestre;

import android.app.Application;
import android.content.Context;

import com.google.gson.GsonBuilder;

import dagger.hilt.android.HiltAndroidApp;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@HiltAndroidApp
public class MyApplication extends Application {

    private static Context context;

    private static String apiUrl;

    public static String getApiUrl() {
        if(apiUrl ==null){
            apiUrl=BASE_URL;
        }
        return apiUrl;
    }

    private static final String BASE_URL = "https://teste-q43i.onrender.com/";

    public static Context getAppContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(getApiUrl())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
    }
}
