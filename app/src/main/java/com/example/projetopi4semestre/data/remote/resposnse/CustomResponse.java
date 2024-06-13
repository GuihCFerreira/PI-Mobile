package com.example.projetopi4semestre.data.remote.resposnse;

public class CustomResponse {

    private int codigo;
    private String message;

    public CustomResponse(int codigo, String mensagem) {
        this.codigo = codigo;
        this.message = mensagem;
    }

    public CustomResponse(String mensagem) {
        this.message = mensagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return message;
    }

    public void setMensagem(String mensagem) {
        this.message = mensagem;
    }

}
