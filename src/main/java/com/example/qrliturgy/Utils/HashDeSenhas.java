package com.example.qrliturgy.Utils;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class HashDeSenhas {

    public String codificarSenha(String senha){
        String Salt = BCrypt.gensalt();

        return BCrypt.hashpw(senha, Salt);
    }

    public Boolean verificaSenha(String senha, String senhaDB ){
        return BCrypt.checkpw(senha, senhaDB);
    }

}
