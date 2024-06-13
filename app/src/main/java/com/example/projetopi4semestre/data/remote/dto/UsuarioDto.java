package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Usuario;
import com.google.gson.annotations.SerializedName;

public class UsuarioDto {

    @SerializedName("name")
    private String nome;
    @SerializedName("email")
    private String email;
    @SerializedName("token")
    private String token;

    public Usuario toModel(){
        return new Usuario(
                nome, email, token
        );
    }
}
