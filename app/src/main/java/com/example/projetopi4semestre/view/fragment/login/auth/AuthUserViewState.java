package com.example.projetopi4semestre.view.fragment.login.auth;

import androidx.lifecycle.MutableLiveData;

import com.example.projetopi4semestre.domain.model.Usuario;

public class AuthUserViewState {

    private MutableLiveData<Usuario> usuario;
    private MutableLiveData<Boolean> carregando;
    private MutableLiveData<String> mensagem;

    public AuthUserViewState() {
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
