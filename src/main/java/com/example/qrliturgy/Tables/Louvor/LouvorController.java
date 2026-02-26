package com.example.qrliturgy.Tables.Louvor;

import com.example.qrliturgy.Tables.Louvor.DTO.LouvorDTORequest;
import com.example.qrliturgy.Tables.Louvor.DTO.LouvorDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("louvor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LouvorController {

    private final LouvorService louvorService;

    public LouvorController(LouvorService louvorService) {
        this.louvorService = louvorService;
    }

    @GetMapping("/get_louvores")
    public ResponseEntity<?> getLovores(){
        List<LouvorDTOResponse> louvores = louvorService.getLouvores();
        return ResponseEntity.status(200).body(louvores);
    }

    @PostMapping("/new_louvor")
    public ResponseEntity<?> newLouvor(@RequestBody LouvorDTORequest dto){
        LouvorDTOResponse louvor = louvorService.newLouvor(dto);
        return ResponseEntity.status(201).body(louvor);
    }

    @GetMapping("/get_louvor/{id}")
    public ResponseEntity<?> getLouvor(@PathVariable long id){
        LouvorDTOResponse louvor = louvorService.getLouvor(id);
        return ResponseEntity.status(200).body(louvor);
    }
}
