package com.example.qrliturgy.Tables.Liturgia.DTO;

import com.example.qrliturgy.Tables.Avisos.Entity.AvisoEntity;
import com.example.qrliturgy.Tables.Louvor.LouvorEntity;

import java.util.List;

public record LiturgiaDTORequest(
        String culto,
        String tema,
        String pregador,
        boolean ceia,
        String observacao,
        List<LouvorEntity> louvores,
        List<AvisoEntity> avisos,
        String passagemBiblica
) {
}
