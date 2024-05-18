package com.example.projetopi4semestre.view.fragment.history.temperatura;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.model.Umidade;
import com.example.projetopi4semestre.domain.usecase.temperatura.GetTemperaturaHistoricoUseCase;
import com.example.projetopi4semestre.domain.usecase.umidade.GetUmidadeHistoricoUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TemperaturaHistoricoViewModel extends ViewModel {

    private final GetTemperaturaHistoricoUseCase useCase;
    private final GetUmidadeHistoricoUseCase umidadeHistoricoUseCase;
    private TemperaturaHistoricoViewState viewState = new TemperaturaHistoricoViewState();

    @Inject
    public TemperaturaHistoricoViewModel(GetTemperaturaHistoricoUseCase useCase, GetUmidadeHistoricoUseCase umidadeUseCase) {
        this.useCase = useCase;
        this.umidadeHistoricoUseCase = umidadeUseCase;
    }

    public void getTemperaturaHistorico(){

        useCase.setRequestCallback(new RequestCallback<List<Temperatura>>() {
            @Override
            public void carregando(boolean carregando) {
                viewState.getCarregando().setValue(carregando);
            }

            @Override
            public void sucesso(List<Temperatura> dados) {
                viewState.getTemperaturaHistorico().setValue(dados);
            }

            @Override
            public void mensagem(CustomResponse response) {
                viewState.getMensagem().setValue(response.getMensagem());
            }
        });

        useCase.getTemperaturaHistorico();
    }

    public void getUmidadeHistorico(){
        umidadeHistoricoUseCase.setRequestCallback(new RequestCallback<List<Umidade>>() {
            @Override
            public void carregando(boolean carregando) {
                viewState.getCarregando().setValue(carregando);
            }

            @Override
            public void sucesso(List<Umidade> dados) {
                viewState.getUmidadeHistorico().setValue(dados);
            }

            @Override
            public void mensagem(CustomResponse response) {
                viewState.getMensagem().setValue(response.getMensagem());
            }
        });

        umidadeHistoricoUseCase.getUmidadeHistorico();
    }

    public TemperaturaHistoricoViewState getViewState() {
        return viewState;
    }
}