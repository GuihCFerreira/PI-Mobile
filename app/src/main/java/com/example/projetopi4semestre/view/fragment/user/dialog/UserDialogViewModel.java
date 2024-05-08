package com.example.projetopi4semestre.view.fragment.user.dialog;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.parametros.ParametrosTrocarSenha;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.domain.usecase.Usuario.ResetPasswordUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserDialogViewModel extends ViewModel {

    private final ResetPasswordUseCase useCase;
    private UserDialogViewState viewState = new UserDialogViewState();

    @Inject
    public UserDialogViewModel(ResetPasswordUseCase useCase) {
        this.useCase = useCase;
    }



    public void resetarSenha(String email, String senhaAtual, String senhaNova){
        useCase.setRequestCallback(new RequestCallback<Usuario>() {
            @Override
            public void carregando(boolean carregando) {
                getViewState().getCarregando().setValue(carregando);
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

        useCase.resetPassword(new ParametrosTrocarSenha(email, senhaAtual, senhaNova));
    }

    public UserDialogViewState getViewState() {
        return viewState;
    }
}