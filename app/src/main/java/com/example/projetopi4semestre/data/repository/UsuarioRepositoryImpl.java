package com.example.projetopi4semestre.data.repository;

import com.example.projetopi4semestre.data.remote.dto.TokenDto;
import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosCriarUsuario;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosLogarUsuario;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosTrocarSenha;
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
    public Call<UsuarioDto> loginUser(ParametrosLogarUsuario parametrosLogarUsuario) {
        return usuarioService.loginUser(parametrosLogarUsuario );
    }

    @Override
    public Call<UsuarioDto> createUser(ParametrosCriarUsuario parametrosCriarUsuario) {
        return usuarioService.createUser(parametrosCriarUsuario);
    }

    @Override
    public Call<UsuarioDto> resetPassword(ParametrosTrocarSenha parametrosTrocarSenha) {
        return usuarioService.resetPassword( parametrosTrocarSenha);
    }

    @Override
    public Call<TokenDto> renewToken() {
        return usuarioService.renewToken();
    }
}
