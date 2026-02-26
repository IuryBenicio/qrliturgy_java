package com.example.qrliturgy.Tables.Liturgia;

import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTORequest;
import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTOResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("liturgia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LiturgiaController {

    private final LiturgiaService liturgiaService;

    public LiturgiaController(LiturgiaService liturgiaService) {
        this.liturgiaService = liturgiaService;
    }

    @GetMapping("/last_liturgia")
    public ResponseEntity<?> getLiturgia() {
        LiturgiaDTOResponse liturgia = liturgiaService.getLiturgia();
        return ResponseEntity.status(200).body(liturgia);
    }

    @PatchMapping("/edit_liturgia/{id}")
    public ResponseEntity<?> editLiturgia(@PathVariable long id , @RequestBody LiturgiaDTORequest dto){
        LiturgiaDTOResponse liturgia = liturgiaService.editLiturgia( id, dto);
        return ResponseEntity.status(200).body(liturgia);
    }

    @PostMapping("/new_liturgia")
    public ResponseEntity<?> newLiturgia(@RequestBody LiturgiaDTORequest dto){
        LiturgiaDTOResponse liturgia = liturgiaService.newLiturgia(dto);
        return ResponseEntity.status(201).body(liturgia);
    }
}
