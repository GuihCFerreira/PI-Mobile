package com.example.projetopi4semestre.data.di;

import com.example.projetopi4semestre.data.remote.service.DashboardService;
import com.example.projetopi4semestre.data.remote.service.TemperaturaService;
import com.example.projetopi4semestre.data.remote.service.UmidadeService;
import com.example.projetopi4semestre.data.remote.service.UsuarioService;
import com.example.projetopi4semestre.data.repository.DashboardRepositoryImpl;
import com.example.projetopi4semestre.data.repository.TemperaturaRepositoryImpl;
import com.example.projetopi4semestre.data.repository.UmidadeRepositoryImpl;
import com.example.projetopi4semestre.data.repository.UsuarioRepositoryImpl;
import com.example.projetopi4semestre.domain.repository.DashboardRepository;
import com.example.projetopi4semestre.domain.repository.TemperaturaRepository;
import com.example.projetopi4semestre.domain.repository.UmidadeRepository;
import com.example.projetopi4semestre.domain.repository.UsuarioRepository;

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

    @Provides
    @Singleton
    public UsuarioRepository provideUsuarioRepository (UsuarioService usuarioService){
        return new UsuarioRepositoryImpl(usuarioService);
    }

    @Provides
    @Singleton
    public DashboardRepository provideDashboardRepository (DashboardService dashboardService){
        return new DashboardRepositoryImpl(dashboardService);
    }

}
