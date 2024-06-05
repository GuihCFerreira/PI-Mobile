package com.example.projetopi4semestre.domain.repository;

import com.example.projetopi4semestre.data.remote.dto.DashboardDto;

import retrofit2.Call;

public interface DashboardRepository {

    Call<DashboardDto> getDashboard(String dataInicial, String dataFinal);

}
