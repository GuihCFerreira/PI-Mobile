package com.example.projetopi4semestre.domain.usecase.temperatura;

import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.repository.TemperaturaRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class GetTemperaturaHistoricoUseCase {

    private final TemperaturaRepository repository;
    private RequestCallback<List<Temperatura>> requestCallback;

    @Inject
    public GetTemperaturaHistoricoUseCase(TemperaturaRepository repository) {
        this.repository = repository;
    }

    public void getTemperaturaHistorico(){
        requestCallback.carregando(true);
        repository.getTemperaturaHistorico().enqueue(new CustomCallback<>(new UseCaseCallback<List<TemperaturaDto>>() {
            @Override
            public void onSuccess(List<TemperaturaDto> response) {
                requestCallback.carregando(false);
                requestCallback.sucesso(response.stream().map(TemperaturaDto::toModel).collect(Collectors.toList()));
            }

            @Override
            public void onFailure(CustomResponse customResponse) {
                requestCallback.carregando(false);
                requestCallback.mensagem(customResponse);
            }
        }));
    }

    public void setRequestCallback(RequestCallback<List<Temperatura>> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
