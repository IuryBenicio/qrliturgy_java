package com.example.qrliturgy.Tables.Louvor;

import com.example.qrliturgy.Tables.Louvor.DTO.LouvorDTORequest;
import com.example.qrliturgy.Tables.Louvor.DTO.LouvorDTOResponse;
import com.example.qrliturgy.Tables.Louvor.exceptions.LouvorNotCreated;
import com.example.qrliturgy.Tables.Louvor.exceptions.LouvorNotFounded;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LouvorService {

    private final LouvorRepository louvorRepository;
    private final LouvorMapper louvorMapper;
    private final LouvorUtils louvorUtils;

    public LouvorService(LouvorRepository louvorRepository, LouvorMapper louvorMapper, LouvorUtils louvorUtils) {
        this.louvorRepository = louvorRepository;
        this.louvorMapper = louvorMapper;
        this.louvorUtils = louvorUtils;
    }

    public List<LouvorDTOResponse> getLouvores(){
        try{
            List<LouvorEntity> louvores = louvorRepository.findAll();
            if(louvores.isEmpty()){
                return Collections.emptyList();
            }
            return louvorMapper.toDTOList(louvores);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar louvores" + e.getMessage());
        }
    }

    public LouvorDTOResponse newLouvor(LouvorDTORequest dto){

        try{
            LouvorEntity newLouvor = louvorUtils.addLouvor(dto);

            louvorRepository.save(newLouvor);
            return louvorMapper.toDTO(newLouvor);
        } catch (Exception e) {
            throw new LouvorNotCreated("Louvor não criado: " + e.getMessage());
        }
    }

    public LouvorDTOResponse getLouvor(long id){
            LouvorEntity louvor = louvorRepository.findById(id).orElseThrow(()-> new LouvorNotFounded("Louvor não encontrado"));
            return louvorMapper.toDTO(louvor);
    }
}
