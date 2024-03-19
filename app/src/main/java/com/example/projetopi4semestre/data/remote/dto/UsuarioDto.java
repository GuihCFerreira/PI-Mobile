package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Usuario;

public class UsuarioDto {

    private String nome;
    private String email;
    private String token;

    public Usuario toModel(){
        return new Usuario(
                nome, email, token
        );
    }
}
