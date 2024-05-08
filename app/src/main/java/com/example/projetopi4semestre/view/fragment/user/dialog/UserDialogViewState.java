package com.example.projetopi4semestre.view.fragment.user.dialog;

import androidx.lifecycle.MutableLiveData;

import com.example.projetopi4semestre.domain.model.Usuario;

public class UserDialogViewState {

    private MutableLiveData<Usuario> usuario;
    private MutableLiveData<String> mensagem;
    private MutableLiveData<Boolean> carregando;

    public UserDialogViewState() {
        usuario = new MutableLiveData<>();
        mensagem = new MutableLiveData<>();
        carregando = new MutableLiveData<>(false);
    }

    public MutableLiveData<Usuario> getUsuario() {
        return usuario;
    }

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }

    public MutableLiveData<Boolean> getCarregando() {
        return carregando;
    }
}
