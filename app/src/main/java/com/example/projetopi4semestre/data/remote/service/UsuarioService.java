package com.example.projetopi4semestre.data.remote.service;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;
import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosCriarUsuario;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosLogarUsuario;
import com.example.projetopi4semestre.data.remote.parametros.ParametrosTrocarSenha;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    String ENDPOINT_CREATE_USER = "user/createUser";
    String ENDPOINT_LOGIN = "user/loginUser";
    String ENDPOINT_RESET_SENHA = "user/resetPassword";

    @POST (ENDPOINT_LOGIN)
    Call<UsuarioDto> loginUser(@Body ParametrosLogarUsuario parametrosLogarUsuario);
    @POST(ENDPOINT_CREATE_USER)
    Call<UsuarioDto> createUser(@Body ParametrosCriarUsuario parametrosCriarUsuario);
    Call<UsuarioDto> resetPassword(@Body ParametrosTrocarSenha parametrosTrocarSenha);
}
