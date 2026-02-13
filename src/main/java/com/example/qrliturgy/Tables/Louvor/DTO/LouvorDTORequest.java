package com.example.qrliturgy.Tables.Louvor.DTO;

import jakarta.validation.constraints.NotBlank;



public record LouvorDTORequest(
        @NotBlank String nome,
        @NotBlank String letra) {}
