package com.example.projetopi4semestre.data.remote.service;

import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TemperaturaService {

    String ENDPOINT_ATUAL  = "temperatures";
    String ENDPOINT_HISTORICO  = "temperatures";

    @GET(ENDPOINT_ATUAL)
    Call<TemperaturaDto> getTemperaturaAtual(@Query("latest") boolean latest);

    @GET(ENDPOINT_HISTORICO)
    Call<List<TemperaturaDto>> getTemperaturaHistorico();

}
