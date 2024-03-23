package com.example.projetopi4semestre.view.fragment.home;

import androidx.lifecycle.MutableLiveData;

import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.model.Umidade;

public class HomeViewState {

    private MutableLiveData<Umidade> umidade;
    private MutableLiveData<Temperatura> temperatura;
    private MutableLiveData<String> mensagem;
    private MutableLiveData<Boolean> carregando;

    public HomeViewState() {
        umidade = new MutableLiveData<>();
        temperatura = new MutableLiveData<>();
        mensagem = new MutableLiveData<>();
        carregando = new MutableLiveData<>();
    }

    public MutableLiveData<Umidade> getUmidade() {
        return umidade;
    }

    public MutableLiveData<Temperatura> getTemperatura() {
        return temperatura;
    }

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }

    public MutableLiveData<Boolean> getCarregando() {
        return carregando;
    }
}
