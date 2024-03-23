package com.example.projetopi4semestre.view.fragment.login.create;

import androidx.lifecycle.MutableLiveData;

import com.example.projetopi4semestre.domain.model.Usuario;

public class CreateUserViewState {

    private MutableLiveData<Usuario> usuario;
    private MutableLiveData<Boolean> carregando;
    private MutableLiveData<String> mensagem;

    public CreateUserViewState() {
        usuario = new MutableLiveData<>();
        carregando = new MutableLiveData<>(false);
         mensagem = new MutableLiveData<>();
    }

    public MutableLiveData<Usuario> getUsuario() {
        return usuario;
    }

    public MutableLiveData<Boolean> getCarregando() {
        return carregando;
    }

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }
}
