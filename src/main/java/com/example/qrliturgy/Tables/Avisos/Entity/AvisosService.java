package com.example.qrliturgy.Tables.Avisos.Entity;

import com.example.qrliturgy.Tables.Avisos.Entity.DTO.AvisoDTOResponse;
import com.example.qrliturgy.Tables.Avisos.Entity.exceptions.AvisoNotFounded;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AvisosService {

    private final AvisosRepository avisosRepository;
    private final AvisosMapper avisosMapper;

    public AvisosService(AvisosRepository avisosRepository, AvisosMapper avisosMapper) {
        this.avisosRepository = avisosRepository;
        this.avisosMapper = avisosMapper;
    }

    public List<AvisoDTOResponse> getAvisos(){
        List<AvisoEntity> avisos = avisosRepository.findAll();

        if(avisos.isEmpty()){
            return Collections.emptyList();
        }

        return avisosMapper.toDTOList(avisos);
    }

    public AvisoDTOResponse getAviso(long id){
        AvisoEntity aviso = avisosRepository.findById(id).orElseThrow(()-> new AvisoNotFounded("Aviso não encontrado!"));
        return avisosMapper.toDTO(aviso);
    }
}
