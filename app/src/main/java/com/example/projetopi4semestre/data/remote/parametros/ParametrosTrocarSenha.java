package com.example.projetopi4semestre.data.remote.parametros;

public class ParametrosTrocarSenha {

    private String email;
    private String senhaAtual;
    private String senhaNova;

    public ParametrosTrocarSenha(String email, String senhaAtual, String senhaNova) {
        this.email = email;
        this.senhaAtual = senhaAtual;
        this.senhaNova = senhaNova;
    }
}
