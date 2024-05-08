package com.example.projetopi4semestre.domain.usecase.Usuario;

import com.example.projetopi4semestre.data.remote.dto.TokenDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Token;
import com.example.projetopi4semestre.domain.repository.UsuarioRepository;

import javax.inject.Inject;

public class RenewTokenUseCase {

    private final UsuarioRepository repository;

    private RequestCallback<Token> requestCallback;

    @Inject
    public RenewTokenUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void renewToken(){
        requestCallback.carregando(true);
        repository.renewToken().enqueue(new CustomCallback<>(new UseCaseCallback<TokenDto>() {
            @Override
            public void onSuccess(TokenDto response) {
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

    public void setResourceUseCase(RequestCallback<Token> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
