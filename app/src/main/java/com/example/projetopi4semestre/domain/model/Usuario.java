package com.example.projetopi4semestre.domain.model;

public class Usuario {

    private String nome;
    private String email;
    private String token;

    public Usuario(String nome, String email, String token) {
        this.nome = nome;
        this.email = email;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
