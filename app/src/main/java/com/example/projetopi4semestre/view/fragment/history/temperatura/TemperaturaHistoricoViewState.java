package com.example.projetopi4semestre.view.fragment.history.temperatura;

import androidx.lifecycle.MutableLiveData;

import com.example.projetopi4semestre.domain.model.Temperatura;

import java.util.ArrayList;
import java.util.List;

public class TemperaturaHistoricoViewState {

    private MutableLiveData<List<Temperatura>> temperaturaHistorico;
    private MutableLiveData<Boolean> carregando;
    private MutableLiveData<String> mensagem;

    public TemperaturaHistoricoViewState() {
        temperaturaHistorico = new MutableLiveData<>(new ArrayList<>());
        carregando = new MutableLiveData<>(true);
        mensagem = new MutableLiveData<>();
    }

    public MutableLiveData<List<Temperatura>> getTemperaturaHistorico() {
        return temperaturaHistorico;
    }

    public MutableLiveData<Boolean> getCarregando() {
        return carregando;
    }

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }
}
