package com.example.projetopi4semestre.data.remote.service;

import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TemperaturaService {

    String ENDPOINT_ATUAL  = "temperatura/getTemperaturaAtual";
    String ENDPOINT_HISTORICO  = "temperatura/getTemperaturaHistorico";

    @GET(ENDPOINT_ATUAL)
    Call<TemperaturaDto> getTemperaturaAtual();

    @GET(ENDPOINT_HISTORICO)
    Call<List<TemperaturaDto>> getTemperaturaHistorico();

}
