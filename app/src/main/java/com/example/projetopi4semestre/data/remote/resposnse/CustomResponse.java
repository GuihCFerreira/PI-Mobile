package com.example.projetopi4semestre.data.remote.resposnse;

public class CustomResponse {

    private int codigo;
    private String mensagem;

    public CustomResponse(int codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public CustomResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
