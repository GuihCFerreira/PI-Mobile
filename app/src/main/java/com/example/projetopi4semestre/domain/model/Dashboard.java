package com.example.projetopi4semestre.domain.model;

public class Dashboard {

    private Estatistica temperatura;
    private Estatistica umidade;

    public Dashboard(Estatistica temperatura, Estatistica umidade) {
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    public Estatistica getTemperatura() {
        return temperatura;
    }

    public Estatistica getUmidade() {
        return umidade;
    }
}
