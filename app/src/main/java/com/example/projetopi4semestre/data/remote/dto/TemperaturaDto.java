package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Temperatura;
import com.google.gson.annotations.SerializedName;

public class TemperaturaDto {

    @SerializedName("temperature")
    private String temperatura;
    @SerializedName("date")
    private String data;
    @SerializedName("time")
    private String hora;

    public Temperatura toModel(){
        return new Temperatura(
                temperatura,
                data,
                hora
        );
    }
}
