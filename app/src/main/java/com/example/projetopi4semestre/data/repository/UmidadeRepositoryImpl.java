package com.example.projetopi4semestre.data.repository;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;
import com.example.projetopi4semestre.data.remote.service.UmidadeService;
import com.example.projetopi4semestre.domain.repository.UmidadeRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class UmidadeRepositoryImpl implements UmidadeRepository {

    private final UmidadeService umidadeService;

    @Inject
    public UmidadeRepositoryImpl(UmidadeService umidadeService) {
        this.umidadeService = umidadeService;
    }

    @Override
    public Call<UmidadeDto> getUmidadeAtual(boolean latest) {
        return umidadeService.getUmidadeAtual(latest);
    }

    @Override
    public Call<List<UmidadeDto>> getUmidadeHistorico() {
        return umidadeService.getUmidadeHistorico();
    }
}
