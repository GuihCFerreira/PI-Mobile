package com.example.projetopi4semestre.domain.repository;

import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;

import java.util.List;

import retrofit2.Call;

public interface TemperaturaRepository {

    Call<TemperaturaDto> getTemperturaAtual();
    Call<List<TemperaturaDto>> getTemperaturaHistorico();
}
