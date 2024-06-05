package com.example.projetopi4semestre.data.remote.service;

import com.example.projetopi4semestre.data.remote.dto.DashboardDto;
import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DashboardService {

    String ENDPOINT_DASHBOARD  = "dashboard";

    @GET(ENDPOINT_DASHBOARD)
    Call<DashboardDto> getDashboard(
            @Query("dataInicial") String dataInicial,
            @Query("dataFinal") String dataFinal
    );
}
