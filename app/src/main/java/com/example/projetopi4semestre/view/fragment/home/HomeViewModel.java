package com.example.projetopi4semestre.view.fragment.home;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.model.Umidade;
import com.example.projetopi4semestre.domain.usecase.temperatura.GetTemperaturaAtualUseCase;
import com.example.projetopi4semestre.domain.usecase.umidade.GetUmidadeAtualUseCase;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    private HomeViewState viewState = new HomeViewState();
    private final GetUmidadeAtualUseCase umidadeAtualUseCase;
    private final GetTemperaturaAtualUseCase temperaturaAtualUseCase;

    @Inject
    public HomeViewModel(GetUmidadeAtualUseCase umidadeAtualUseCase, GetTemperaturaAtualUseCase temperaturaAtualUseCase) {
        this.umidadeAtualUseCase = umidadeAtualUseCase;
        this.temperaturaAtualUseCase = temperaturaAtualUseCase;
    }

    public void getValoresAtuais(){

    }

    private void getUmidadeAtual(){
        umidadeAtualUseCase.setRequestCallback(new RequestCallback<Umidade>() {
            @Override
            public void carregando(boolean carregando) {
                viewState.getCarregando().setValue(carregando);
            }

            @Override
            public void sucesso(Umidade dados) {
                viewState.getUmidade().setValue(dados);
            }

            @Override
            public void erro(CustomResponse response) {
                viewState.getMensagem().setValue(response.getMensagem());
            }
        });

        umidadeAtualUseCase.getUmidadeAtual();
    }

    private void getTemperaturaAtual(){
        temperaturaAtualUseCase.setRequestCallback(new RequestCallback<Temperatura>() {
            @Override
            public void carregando(boolean carregando) {
                viewState.getCarregando().setValue(carregando);
            }

            @Override
            public void sucesso(Temperatura dados) {
                viewState.getTemperatura().setValue(dados);
            }

            @Override
            public void erro(CustomResponse response) {
                getViewState().getMensagem().setValue(response.getMensagem());
            }
        });

        temperaturaAtualUseCase.getTemperaturaAtual();
    }

    public HomeViewState getViewState() {
        return viewState;
    }
}