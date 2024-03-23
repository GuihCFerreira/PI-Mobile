package com.example.projetopi4semestre.view.fragment.login.create;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.parametros.ParametrosCriarUsuario;
import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Usuario;
import com.example.projetopi4semestre.domain.usecase.Usuario.CreateUserUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CreateUserViewModel extends ViewModel {

    private final CreateUserUseCase useCase;
    private CreateUserViewState viewState = new CreateUserViewState();

    @Inject
    public CreateUserViewModel(CreateUserUseCase useCase) {
        this.useCase = useCase;
    }

    public void createUser(String nome, String email, String senha){
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
            public void erro(CustomResponse response) {
                viewState.getMensagem().setValue(response.getMensagem());
            }
        });

        useCase.createUser(new ParametrosCriarUsuario( nome, email, senha ));
    }

    public CreateUserViewState getViewState() {
        return viewState;
    }
}