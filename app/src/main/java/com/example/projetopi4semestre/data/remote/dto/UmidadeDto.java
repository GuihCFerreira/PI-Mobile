package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Umidade;
import com.google.gson.annotations.SerializedName;

public class UmidadeDto {

    @SerializedName("humidity")
    private String umidade;
    @SerializedName("date")
    private String data;
    @SerializedName("time")
    private String hora;

    public Umidade toModel(){
        return new Umidade(
                umidade,
                data,
                hora
        );
    }
}
