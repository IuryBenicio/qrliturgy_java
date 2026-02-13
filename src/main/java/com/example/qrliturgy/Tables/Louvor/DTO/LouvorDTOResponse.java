package com.example.qrliturgy.Tables.Louvor.DTO;


import com.example.qrliturgy.Tables.Liturgia.LiturgiaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record LouvorDTOResponse(
        @NotNull long id,
        @NotBlank String nome,
        @NotBlank String letra,
        List<LiturgiaEntity> liturgia
) {
}
