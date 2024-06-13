package com.example.projetopi4semestre.data.remote.parametros;

public class ParametrosTrocarSenha {

    private String email;
    private String password;
    private String new_password;

    public ParametrosTrocarSenha(String email, String senhaAtual, String senhaNova) {
        this.email = email;
        this.password = senhaAtual;
        this.new_password = senhaNova;
    }
}
