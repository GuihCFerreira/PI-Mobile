package com.example.projetopi4semestre.data.remote.resposnse;

public interface RequestCallback <T>{

    void carregando(boolean carregando);
    void sucesso(T dados);
    void erro(CustomResponse response);
}
