package com.example.projetopi4semestre.domain.usecase.Usuario;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.resposnse.CustomCallback;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.data.remote.resposnse.UseCaseCallback;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.domain.repository.UsuarioRepository;

import javax.inject.Inject;

public class ResetPasswordUseCase {

    private final UsuarioRepository usuarioRepository;
    private RequestCallback<Usuario> requestCallback;

    @Inject
    public ResetPasswordUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void resetPassword(String nome, String email, String senhaAtual, String senhaNova){
        requestCallback.carregando(true);
        usuarioRepository.resetPassword(email,senhaAtual, senhaNova )
                .enqueue(new CustomCallback<>(new UseCaseCallback<UsuarioDto>() {
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
