package com.example.projetopi4semestre.domain.repository;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;

import java.util.List;

import retrofit2.Call;

public interface UmidadeRepository {

    Call<UmidadeDto> getUmidadeAtual();
    Call<List<UmidadeDto>> getUmidadeHistorico();
}
