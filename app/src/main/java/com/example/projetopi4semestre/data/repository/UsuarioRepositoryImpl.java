package com.example.projetopi4semestre.data.repository;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.service.UsuarioService;
import com.example.projetopi4semestre.domain.repository.UsuarioRepository;

import javax.inject.Inject;

import retrofit2.Call;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioService usuarioService;

    @Inject
    public UsuarioRepositoryImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Override
    public Call<UsuarioDto> loginUser(String email, String senha) {
        return usuarioService.loginUser(email, senha);
    }

    @Override
    public Call<UsuarioDto> createUser(String nome, String email, String senha) {
        return usuarioService.createUser(nome, email, senha);
    }

    @Override
    public Call<UsuarioDto> resetPassword( String email, String senhaAtual, String senhaNova) {
        return usuarioService.resetPassword( email, senhaAtual, senhaNova);
    }
}
