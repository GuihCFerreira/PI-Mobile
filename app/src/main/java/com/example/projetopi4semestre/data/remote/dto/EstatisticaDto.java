package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Estatistica;

public class EstatisticaDto {

    private String media;
    private String mediana;
    private String moda;
    private String desvio_padrao;
    private String assimetria;
    private String previsao_futura;

    public Estatistica toModel(){
        return new Estatistica(media, mediana, moda, desvio_padrao, assimetria, previsao_futura);
    }

}
