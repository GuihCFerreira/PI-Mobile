package com.example.projetopi4semestre.domain.usecase.Usuario;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosLogarUsuario;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.domain.repository.UsuarioRepository;

import javax.inject.Inject;

public class LoginUserUseCase {

    private final UsuarioRepository repository;
    private RequestCallback<Usuario> requestCallback;

    @Inject
    public LoginUserUseCase(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void loginUser(ParametrosLogarUsuario parametrosLogarUsuario){
        requestCallback.carregando(true);
        repository.loginUser(parametrosLogarUsuario).enqueue(new CustomCallback<>(new UseCaseCallback<UsuarioDto>() {
            @Override
            public void onSuccess(UsuarioDto response) {
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

    public void setRequestCallback(RequestCallback<Usuario> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
