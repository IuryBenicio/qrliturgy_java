package com.example.qrliturgy.Tables.Liturgia;

import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTORequest;
import org.springframework.stereotype.Component;

@Component
public class LiturgiaMapperNull {

    public void updateEntityFromDTO(LiturgiaDTORequest dto, LiturgiaEntity entity){
        if(dto == null) return;

        //tema
        if (dto.tema() !=null){
            entity.setTema(dto.tema());
        }

        //ceia
        entity.setCeia(dto.ceia());

        //louvores
        if(dto.louvores() != null && !dto.louvores().isEmpty()){
            entity.setLouvores(dto.louvores());
        }

        //avisos
        if(dto.avisos() != null){
            entity.setAvisos(dto.avisos());
        }

        //pregador
        if (dto.pregador() != null){
            entity.setPregador(dto.pregador());
        }

        //observação
        if(dto.observacao() != null){
            entity.setObservacao(dto.observacao());
        }

        //culto
        if(dto.culto() != null){
            entity.setCulto(dto.culto());
        }

        if (dto.passagemBiblica() != null ){
            entity.setPassagemBiblica(dto.passagemBiblica());
        }
    }

    public void createNewEntity(LiturgiaEntity entity, LiturgiaDTORequest dto ){
        entity.setPassagemBiblica(dto.passagemBiblica());
        entity.setCeia(dto.ceia());
        entity.setObservacao(dto.observacao());

        //por ser ontomany e manytoone é preciso fazer a ligação entre as entidades
        if(dto.avisos() != null){
            dto.avisos().forEach((aviso)-> aviso.setLiturgia(entity));
            entity.setAvisos(dto.avisos());
        }

        entity.setLouvores(dto.louvores());
        entity.setPregador(dto.pregador());
        entity.setTema(dto.tema());
        entity.setCulto(dto.culto());
    }

}
