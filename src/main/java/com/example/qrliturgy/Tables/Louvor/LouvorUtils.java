package com.example.qrliturgy.Tables.Louvor;

import com.example.qrliturgy.Tables.Louvor.DTO.LouvorDTORequest;
import org.springframework.stereotype.Component;

@Component
public class LouvorUtils {

    public LouvorEntity addLouvor(LouvorDTORequest dto){
        LouvorEntity newLouvor = new LouvorEntity();
        newLouvor.setNome(dto.nome());
        newLouvor.setLetra(dto.letra());

        return newLouvor;
    }

}
