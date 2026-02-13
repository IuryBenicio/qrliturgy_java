package com.example.qrliturgy.Tables.Louvor;

import com.example.qrliturgy.Tables.Louvor.DTO.LouvorDTOResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LouvorMapper {

    LouvorEntity toEntity(LouvorDTOResponse dto);

    LouvorDTOResponse toDTO(LouvorEntity entity);

    List<LouvorDTOResponse> toDTOList(List<LouvorEntity> entity);

}
