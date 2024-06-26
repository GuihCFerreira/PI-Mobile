package com.example.projetopi4semestre.data.di;

import com.example.projetopi4semestre.data.remote.service.DashboardService;
import com.example.projetopi4semestre.data.remote.service.TemperaturaService;
import com.example.projetopi4semestre.data.remote.service.UmidadeService;
import com.example.projetopi4semestre.data.remote.service.UsuarioService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class ServiceModule {

    @Provides
    @Singleton
    public static TemperaturaService provideTemperaturaService(Retrofit retrofit){
        return retrofit.create(TemperaturaService.class);
    }

    @Provides
    @Singleton
    public static UmidadeService provideUmidadeService(Retrofit retrofit){
        return retrofit.create(UmidadeService.class);
    }
    @Provides
    @Singleton
    public static UsuarioService provideUsuarioService(Retrofit retrofit){
        return retrofit.create(UsuarioService.class);
    }

    @Provides
    @Singleton
    public static DashboardService provideDashboardService(Retrofit retrofit){
        return retrofit.create(DashboardService.class);
    }

}
