package com.example.projetopi4semestre.data.remote.service;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;

import java.util.List;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UmidadeService {

    String ENDPOINT_ATUAL = "humidities";
    String ENDPOINT_HISTORICO = "humidities";

    @GET(ENDPOINT_ATUAL)
    Call<UmidadeDto> getUmidadeAtual(@Query("latest") boolean latest);

    @GET(ENDPOINT_HISTORICO)
    Call<List<UmidadeDto>> getUmidadeHistorico();
}
