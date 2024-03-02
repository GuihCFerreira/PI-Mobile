package com.example.projetopi4semestre.domain.model;

public class Temperatura {

    private String temperatura;
    private String unidadeMedida;
    private String data;
    private String hora;
    private String criado;

    public String getTemperatura() {
        return temperatura;
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

    public Temperatura(String temperatura, String unidadeMedida, String data, String hora, String criado) {
        this.temperatura = temperatura;
        this.unidadeMedida = unidadeMedida;
        this.data = data;
        this.hora = hora;
        this.criado = criado;
    }
}
