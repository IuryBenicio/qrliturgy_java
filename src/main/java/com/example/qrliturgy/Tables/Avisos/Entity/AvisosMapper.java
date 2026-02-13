package com.example.qrliturgy.Tables.Avisos.Entity;

import com.example.qrliturgy.Tables.Avisos.Entity.DTO.AvisoDTOResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvisosMapper {
    AvisoEntity toEntity(AvisoDTOResponse dto);

    AvisoDTOResponse toDTO(AvisoEntity entity);

    List<AvisoDTOResponse> toDTOList(List<AvisoEntity> entityList);
}
