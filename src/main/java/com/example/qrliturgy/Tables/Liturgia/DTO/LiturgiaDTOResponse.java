package com.example.qrliturgy.Tables.Liturgia.DTO;

import com.example.qrliturgy.Tables.Avisos.Entity.AvisoEntity;
import com.example.qrliturgy.Tables.Liturgia.LiturgiaOrdemEnum;
import com.example.qrliturgy.Tables.Louvor.LouvorEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record LiturgiaDTOResponse(
        long id,
        @NotBlank String culto,
        @NotBlank String tema,
        String pregador,
        @NotNull boolean ceia,
        @NotBlank String observacao,
        @NotNull Set<LouvorEntity> louvores,
        List<AvisoEntity> avisos,
        List<LiturgiaOrdemEnum> ordemLiturgica,
        String passagemBiblica)
{}
