package com.example.projetopi4semestre.data.repository;

import com.example.projetopi4semestre.data.remote.dto.DashboardDto;
import com.example.projetopi4semestre.data.remote.service.DashboardService;
import com.example.projetopi4semestre.domain.repository.DashboardRepository;

import javax.inject.Inject;

import retrofit2.Call;

public class DashboardRepositoryImpl implements DashboardRepository {

    private final DashboardService service;

    @Inject
    public DashboardRepositoryImpl(DashboardService service) {
        this.service = service;
    }

    @Override
    public Call<DashboardDto> getDashboard(String dataInicial, String dataFinal) {
        return service.getDashboard(dataInicial, dataFinal);
    }
}
