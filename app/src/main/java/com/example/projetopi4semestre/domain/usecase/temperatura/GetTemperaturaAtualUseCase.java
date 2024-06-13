package com.example.projetopi4semestre.domain.usecase.temperatura;

import com.example.projetopi4semestre.data.remote.dto.TemperaturaDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.repository.TemperaturaRepository;

import javax.inject.Inject;

public class GetTemperaturaAtualUseCase {

    private final TemperaturaRepository temperaturaRepository;
    private RequestCallback<Temperatura> requestCallback;

    @Inject
    public GetTemperaturaAtualUseCase(TemperaturaRepository temperaturaRepository) {
        this.temperaturaRepository = temperaturaRepository;
    }

    public void getTemperaturaAtual(boolean latest){
        //requestCallback.carregando(true);
        temperaturaRepository.getTemperturaAtual(latest).enqueue(new CustomCallback<>(new UseCaseCallback<TemperaturaDto>() {
            @Override
            public void onSuccess(TemperaturaDto response) {
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

    public void setRequestCallback(RequestCallback<Temperatura> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
