package com.example.projetopi4semestre.view.fragment.history.temperatura;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Temperatura;
import com.example.projetopi4semestre.domain.usecase.temperatura.GetTemperaturaHistoricoUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class TemperaturaHistoricoViewModel extends ViewModel {

    private final GetTemperaturaHistoricoUseCase useCase;
    private TemperaturaHistoricoViewState viewState = new TemperaturaHistoricoViewState();

    @Inject
    public TemperaturaHistoricoViewModel(GetTemperaturaHistoricoUseCase useCase) {
        this.useCase = useCase;
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

    public TemperaturaHistoricoViewState getViewState() {
        return viewState;
    }
}