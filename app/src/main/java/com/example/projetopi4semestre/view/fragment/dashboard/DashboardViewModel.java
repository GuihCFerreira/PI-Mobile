package com.example.projetopi4semestre.view.fragment.dashboard;

import androidx.lifecycle.ViewModel;

import com.example.projetopi4semestre.data.remote.resposnse.CustomResponse;
import com.example.projetopi4semestre.data.remote.resposnse.RequestCallback;
import com.example.projetopi4semestre.domain.model.Dashboard;
import com.example.projetopi4semestre.domain.usecase.dashboard.GetDashboardUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DashboardViewModel extends ViewModel {

    private final GetDashboardUseCase useCase;
    private final DashboardViewState viewState = new DashboardViewState();

    @Inject
    public DashboardViewModel(GetDashboardUseCase useCase) {
        this.useCase = useCase;
    }

    public void getDashboard(String dataInicial, String dataFinal){
        useCase.setRequestCallback(new RequestCallback<Dashboard>() {
            @Override
            public void carregando(boolean carregando) {
                viewState.getCarregando().setValue(carregando);
            }

            @Override
            public void sucesso(Dashboard dados) {
                viewState.getDashboard().setValue(dados);
            }

            @Override
            public void mensagem(CustomResponse response) {
                viewState.getMensagem().setValue(response.getMensagem());
            }
        });

        useCase.getDashboard(dataInicial, dataFinal);
    }

    public DashboardViewState getViewState() {
        return viewState;
    }
}