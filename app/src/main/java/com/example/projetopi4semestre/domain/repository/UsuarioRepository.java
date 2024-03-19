package com.example.projetopi4semestre.domain.repository;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;

import retrofit2.Call;

public interface UsuarioRepository {

    Call<UsuarioDto> loginUser(String email, String senha);
    Call<UsuarioDto> createUser(String email, String nome, String senha);
    Call<UsuarioDto> resetPassword(String email,  String senhaAtual ,String senhaNova);
}
