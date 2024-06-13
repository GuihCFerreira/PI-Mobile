package com.example.projetopi4semestre.data.repository;

import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;
import com.example.projetopi4semestre.data.remote.service.TemperaturaService;
import com.example.projetopi4semestre.domain.repository.TemperaturaRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class TemperaturaRepositoryImpl implements TemperaturaRepository {

    private final TemperaturaService temperaturaService;

    @Inject
    public TemperaturaRepositoryImpl(TemperaturaService temperaturaService) {
        this.temperaturaService = temperaturaService;
    }

    @Override
    public Call<TemperaturaDto> getTemperturaAtual(boolean latest) {
        return temperaturaService.getTemperaturaAtual(latest);
    }

    @Override
    public Call<List<TemperaturaDto>> getTemperaturaHistorico() {
        return temperaturaService.getTemperaturaHistorico();
    }
}
