package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Temperatura;

public class TemperaturaDto {

    private String temperatura;
    private String unidadeMedida;
    private String data;
    private String hora;
    private String criado;

    public Temperatura toModel(){
        return new Temperatura(
                temperatura,
                unidadeMedida,
                data,
                hora,
                criado
        );
    }
}
