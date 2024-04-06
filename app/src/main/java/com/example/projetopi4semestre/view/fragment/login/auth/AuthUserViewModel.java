package com.example.projetopi4semestre.view.fragment.login.auth;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.parametros.ParametrosLogarUsuario;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.domain.usecase.Usuario.LoginUserUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AuthUserViewModel extends ViewModel {

    private final LoginUserUseCase useCase;
    private AuthUserViewState viewState = new AuthUserViewState();

    @Inject
    public AuthUserViewModel(LoginUserUseCase useCase) {
        this.useCase = useCase;
    }

    public void logarUsuario(String email, String senha){
        useCase.setRequestCallback(new RequestCallback<Usuario>() {
            @Override
            public void carregando(boolean carregando) {
                viewState.getCarregando().setValue(carregando);
            }

            @Override
            public void sucesso(Usuario dados) {
                viewState.getUsuario().setValue(dados);
            }

            @Override
            public void mensagem(CustomResponse response) {
                viewState.getMensagem().setValue(response.getMensagem());
            }
        });

        useCase.loginUser(new ParametrosLogarUsuario(email, senha));
    }

    public AuthUserViewState getViewState() {
        return viewState;
    }
}