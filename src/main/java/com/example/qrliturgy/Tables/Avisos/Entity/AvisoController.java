package com.example.qrliturgy.Tables.Avisos.Entity;


import com.example.qrliturgy.Tables.Avisos.Entity.DTO.AvisoDTOResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aviso")
public class AvisoController {

    private final AvisosService avisosService;

    public AvisoController(AvisosService avisosService) {
        this.avisosService = avisosService;
    }

    @GetMapping("/avisos")
    public ResponseEntity<?> getAvisos(){
        List<AvisoDTOResponse> avisos = avisosService.getAvisos();
        return ResponseEntity.status(200).body(avisos);
    }

    @GetMapping("/aviso/{id}")
    public ResponseEntity<?> getAviso(@PathVariable @NotNull long id){
        AvisoDTOResponse aviso = avisosService.getAviso(id);
        return ResponseEntity.status(200).body(aviso);
    }

}
