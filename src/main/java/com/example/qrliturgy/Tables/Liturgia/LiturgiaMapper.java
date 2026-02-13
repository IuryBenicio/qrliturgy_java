package com.example.qrliturgy.Tables.Liturgia;

import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTORequest;
import com.example.qrliturgy.Tables.Liturgia.DTO.LiturgiaDTOResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LiturgiaMapper {
    LiturgiaEntity toEntity(LiturgiaDTOResponse dto);

    LiturgiaDTOResponse toDTO(LiturgiaEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(LiturgiaDTORequest dto, @MappingTarget LiturgiaEntity entity);
}
