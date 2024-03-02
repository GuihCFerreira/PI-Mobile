package com.example.projetopi4semestre.data.di;

import com.example.projetopi4semestre.data.remote.service.TemperaturaService;
import com.example.projetopi4semestre.data.remote.service.UmidadeService;
import com.example.projetopi4semestre.data.repository.TemperaturaRepositoryImpl;
import com.example.projetopi4semestre.data.repository.UmidadeRepositoryImpl;
import com.example.projetopi4semestre.domain.repository.TemperaturaRepository;
import com.example.projetopi4semestre.domain.repository.UmidadeRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public TemperaturaRepository provideTemperaturaRepository(TemperaturaService temperaturaService){
        return new TemperaturaRepositoryImpl(temperaturaService);
    }

    @Provides
    @Singleton
    public UmidadeRepository provideUmidadeRepository (UmidadeService umidadeService){
        return new UmidadeRepositoryImpl(umidadeService);
    }

}
