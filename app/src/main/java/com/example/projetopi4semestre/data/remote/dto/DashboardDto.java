package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Dashboard;
import com.google.gson.annotations.SerializedName;

public class DashboardDto {

    @SerializedName("temperature")
    private EstatisticaDto temperatura;
    @SerializedName("humidity")
    private EstatisticaDto umidade;

    public Dashboard toModel (){
        return new Dashboard(temperatura.toModel(), umidade.toModel());
    }

}
