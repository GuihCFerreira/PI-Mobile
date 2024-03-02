package com.example.projetopi4semestre.domain.usecase.umidade;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Umidade;
import com.example.projetopi4semestre.domain.repository.UmidadeRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class GetUmidadeHistoricoUseCase {

    private final UmidadeRepository repository;
    private RequestCallback<List<Umidade>> requestCallback;

    @Inject
    public GetUmidadeHistoricoUseCase(UmidadeRepository repository) {
        this.repository = repository;
    }

    public void getUmidadeHistorico(){
        requestCallback.carregando(true);
        repository.getUmidadeHistorico().enqueue(new CustomCallback<>(new UseCaseCallback<List<UmidadeDto>>() {
            @Override
            public void onSuccess(List<UmidadeDto> response) {
                requestCallback.carregando(false);
                requestCallback.sucesso(response.stream().map(UmidadeDto::toModel).collect(Collectors.toList()));
            }

            @Override
            public void onFailure(CustomResponse customResponse) {
                requestCallback.carregando(false);
                requestCallback.erro(customResponse);
            }
        }));
    }

    public void setRequestCallback(RequestCallback<List<Umidade>> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
