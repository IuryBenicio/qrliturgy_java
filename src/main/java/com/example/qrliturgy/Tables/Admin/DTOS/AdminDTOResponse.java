package com.example.qrliturgy.Tables.Admin.DTOS;

import jakarta.validation.constraints.NotBlank;

public record AdminDTOResponse(
        @NotBlank String nome,
        @NotBlank String email
) {
}
