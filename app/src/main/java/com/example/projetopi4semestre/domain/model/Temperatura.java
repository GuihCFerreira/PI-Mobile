package com.example.projetopi4semestre.domain.model;

public class Temperatura {

    private String temperatura;
    private String data;
    private String hora;

    public String getTemperatura() {
        return temperatura;
    }


    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public Temperatura(String temperatura, String data, String hora) {
        this.temperatura = temperatura;
        this.data = data;
        this.hora = hora;
    }
}
