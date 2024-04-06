package com.example.projetopi4semestre.domain.usecase.Usuario;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosTrocarSenha;
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

    public void resetPassword(ParametrosTrocarSenha parametrosTrocarSenha){
        requestCallback.carregando(true);
        usuarioRepository.resetPassword(parametrosTrocarSenha )
                .enqueue(new CustomCallback<>(new UseCaseCallback<UsuarioDto>() {
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
