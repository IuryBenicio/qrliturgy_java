package com.example.qrliturgy.Tables.Admin.DTOS;

import jakarta.validation.constraints.NotBlank;

public record AdminDTORequest(
        @NotBlank String nome,
        @NotBlank String password,
        @NotBlank String email
) {
}
