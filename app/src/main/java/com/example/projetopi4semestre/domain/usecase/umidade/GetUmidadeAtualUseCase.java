package com.example.projetopi4semestre.domain.usecase.umidade;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Umidade;
import com.example.projetopi4semestre.domain.repository.UmidadeRepository;

import javax.inject.Inject;

public class GetUmidadeAtualUseCase {

    private final UmidadeRepository repository;
    private RequestCallback<Umidade> requestCallback;

    @Inject
    public GetUmidadeAtualUseCase(UmidadeRepository repository) {
        this.repository = repository;
    }

    public void getUmidadeAtual(boolean latest){
        //requestCallback.carregando(true);
        repository.getUmidadeAtual(latest).enqueue(new CustomCallback<>(new UseCaseCallback<UmidadeDto>() {
            @Override
            public void onSuccess(UmidadeDto response) {
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

    public void setRequestCallback(RequestCallback<Umidade> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
