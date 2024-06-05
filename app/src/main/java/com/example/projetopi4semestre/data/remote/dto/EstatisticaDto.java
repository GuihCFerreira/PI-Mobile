package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Estatistica;

public class EstatisticaDto {

    private Double media;
    private Double mediana;
    private Double moda;
    private Double desvioPadrao;
    private Double assimetria;
    private Double previsaoFutura;

    public Estatistica toModel(){
        return new Estatistica(media, mediana, moda, desvioPadrao, assimetria, previsaoFutura);
    }

}
