package com.example.projetopi4semestre.domain.model;

public class Umidade {

    private String umidade;
    private String unidadeMedida;
    private String data;
    private String hora;
    private String criado;

    public String getUmidade() {
        return umidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getCriado() {
        return criado;
    }

    public Umidade(String umidade, String unidadeMedida, String data, String hora, String criado) {
        this.umidade = umidade;
        this.unidadeMedida = unidadeMedida;
        this.data = data;
        this.hora = hora;
        this.criado = criado;
    }
}
