package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Estatistica;

public class EstatisticaDto {

    private String media;
    private String mediana;
    private String moda;
    private String desvioPadrao;
    private String assimetria;
    private String previsaoFutura;

    public Estatistica toModel(){
        return new Estatistica(media, mediana, moda, desvioPadrao, assimetria, previsaoFutura);
    }

}
