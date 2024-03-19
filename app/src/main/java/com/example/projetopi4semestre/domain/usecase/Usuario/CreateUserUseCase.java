package com.example.projetopi4semestre.domain.usecase.Usuario;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.domain.repository.UsuarioRepository;

import javax.inject.Inject;

public class CreateUserUseCase {

    private final UsuarioRepository usuarioRepository;
    private RequestCallback<Usuario> requestCallback;

    @Inject
    public CreateUserUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void createUser(String nome, String email, String senha){
        requestCallback.carregando(true);
        usuarioRepository.createUser(
                email, nome, senha
        ).enqueue(new CustomCallback<>(new UseCaseCallback<UsuarioDto>() {
            @Override
            public void onSuccess(UsuarioDto response) {
                requestCallback.carregando(false);
                requestCallback.sucesso(response.toModel());
            }

            @Override
            public void onFailure(CustomResponse customResponse) {
                requestCallback.carregando(false);
                requestCallback.erro(customResponse);
            }
        }));
    }
    public void setRequestCallback(RequestCallback<Usuario> requestCallback) {
        this.requestCallback = requestCallback;
    }
}
