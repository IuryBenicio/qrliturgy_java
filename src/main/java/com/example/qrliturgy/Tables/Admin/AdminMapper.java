package com.example.qrliturgy.Tables.Admin;

import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AdminMapper {

    AdminEntity toEntity(AdminDTO dto);

    AdminDTO toDTO(AdminEntity entity);

}
