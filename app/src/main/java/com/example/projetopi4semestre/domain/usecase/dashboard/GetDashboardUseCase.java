package com.example.projetopi4semestre.domain.usecase.dashboard;

import com.example.projetopi4semestre.data.remote.dto.DashboardDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Dashboard;
import com.example.projetopi4semestre.domain.repository.DashboardRepository;

import javax.inject.Inject;

public class GetDashboardUseCase {

    private final DashboardRepository repository;
    private RequestCallback<Dashboard> requestCallback;

    @Inject
    public GetDashboardUseCase(DashboardRepository repository) {
        this.repository = repository;
    }

    public void getDashboard(String dataInicial, String dataFinal){
        requestCallback.carregando(true);
        repository.getDashboard(dataInicial, dataFinal)
                .enqueue(new CustomCallback<>(new UseCaseCallback<DashboardDto>() {
                    @Override
                    public void onSuccess(DashboardDto response) {
                        requestCallback.carregando(false);
                        requestCallback.sucesso(response.toModel());
                    }

                    @Override
                    public void onFailure(CustomResponse customResponse) {
                        requestCallback.carregando(false);
                        requestCallback.mensagem(customResponse);
                    }
                }));
    }

    public void setRequestCallback(RequestCallback<Dashboard> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
