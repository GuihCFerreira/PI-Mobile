package com.example.projetopi4semestre.data.remote.parametros;

public class ParametrosCriarUsuario {

    private String name;
    private String email;
    private String password;

    public ParametrosCriarUsuario(String nome, String email, String senha) {
        this.name = nome;
        this.email = email;
        this.password = senha;
    }
}
