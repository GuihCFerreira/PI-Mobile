package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Umidade;

public class UmidadeDto {

    private String umidade;
    private String unidadeMedida;
    private String data;
    private String hora;
    private String criado;

    public Umidade toModel(){
        return new Umidade(
                umidade,
                unidadeMedida,
                data,
                hora,
                criado
        );
    }
}
