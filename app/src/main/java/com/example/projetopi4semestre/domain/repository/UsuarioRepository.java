package com.example.projetopi4semestre.domain.repository;

import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosCriarUsuario;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosLogarUsuario;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosTrocarSenha;

import retrofit2.Call;

public interface UsuarioRepository {

    Call<UsuarioDto> loginUser(ParametrosLogarUsuario parametrosLogarUsuario);
    Call<UsuarioDto> createUser(ParametrosCriarUsuario parametrosCriarUsuario);
    Call<UsuarioDto> resetPassword(ParametrosTrocarSenha parametrosTrocarSenha);
}
