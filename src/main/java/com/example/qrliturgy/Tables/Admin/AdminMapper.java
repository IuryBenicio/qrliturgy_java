package com.example.qrliturgy.Tables.Admin;

import com.example.qrliturgy.Tables.Admin.DTOS.AdminDTOResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface AdminMapper {

    AdminEntity toEntity(AdminDTOResponse dto);

    AdminDTOResponse toDTO(AdminEntity entity);

}
