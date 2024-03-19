package com.example.projetopi4semestre.data.remote.service;

import com.example.projetopi4semestre.data.remote.dto.UmidadeDto;
import com.example.projetopi4semestre.data.remote.dto.UsuarioDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    String ENDPOINT_CREATE_USER = "user/createUser";
    String ENDPOINT_LOGIN = "umidade/loginUser";
    String ENDPOINT_RESET_SENHA = "umidade/resetPassword";

    @POST (ENDPOINT_LOGIN)
    Call<UsuarioDto> loginUser(
            @Body String email,
            @Body String passowrd
    );
    @POST(ENDPOINT_CREATE_USER)
    Call<UsuarioDto> createUser(
            @Body String nome,
            @Body String email,
            @Body String senha
    );
    Call<UsuarioDto> resetPassword(
            @Body String email,
            @Body String senhaAtual,
            @Body String senhaNova
    );
}
