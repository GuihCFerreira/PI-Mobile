package com.example.projetopi4semestre.data.remote.dto;

import com.example.projetopi4semestre.domain.model.Token;

public class TokenDto {

    private String token;

    public Token toModel(){
        return new Token(token);
    }
}
