package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Estatistica;
import com.google.gson.annotations.SerializedName;

public class EstatisticaDto {

    @SerializedName("mean")
    private String media;
    @SerializedName("median")
    private String mediana;
    @SerializedName("mode")
    private String moda;
    @SerializedName("standard_deviation")
    private String desvioPadrao;
    @SerializedName("skewness")
    private String assimetria;
    @SerializedName("future_prediction")
    private String previsaoFutura;

    public Estatistica toModel(){
        return new Estatistica(media, mediana, moda, desvioPadrao, assimetria, previsaoFutura);
    }

}
