package com.example.projetopi4semestre.view.fragment.dashboard;

import androidx.lifecycle.MutableLiveData;

import com.example.projetopi4semestre.domain.model.Dashboard;

public class DashboardViewState {

    private MutableLiveData<Dashboard> dashboard;
    private MutableLiveData<Boolean> carregando;
    private MutableLiveData<String> mensagem;

    public DashboardViewState() {
        carregando = new MutableLiveData<>(true);
        mensagem = new MutableLiveData<>();
        dashboard = new MutableLiveData<>(null);
    }

    public MutableLiveData<Dashboard> getDashboard() {
        return dashboard;
    }

    public MutableLiveData<Boolean> getCarregando() {
        return carregando;
    }

    public MutableLiveData<String> getMensagem() {
        return mensagem;
    }
}
