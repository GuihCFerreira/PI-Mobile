package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Dashboard;

public class DashboardDto {

    private EstatisticaDto temperatura;
    private EstatisticaDto umidade;

    public Dashboard toModel (){
        return new Dashboard(temperatura.toModel(), umidade.toModel());
    }

}
