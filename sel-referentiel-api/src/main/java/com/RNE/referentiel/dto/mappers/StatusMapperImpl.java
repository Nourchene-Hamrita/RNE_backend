package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.entities.Status;

@Component
public class StatusMapperImpl implements StatusMapper {

    private static final StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    @Override
    @Mappings({
        @Mapping(source = "category", target = "category")
    })
    public StatusDTO toDto(Status status) {
        if (status == null) {
            return null;
        }

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setCode(status.getCode());
        statusDTO.setTitle(status.getTitle());
        statusDTO.setDescription(status.getDescription());
        statusDTO.setCategory(status.getCategory());

        return statusDTO;
    }

    @Override
    @Mappings({
        @Mapping(source = "category", target = "category")
    })
    public Status toEntity(StatusDTO statusDTO) {
        if (statusDTO == null) {
            return null;
        }

        Status status = new Status();
        status.setCode(statusDTO.getCode());
        status.setTitle(statusDTO.getTitle());
        status.setDescription(statusDTO.getDescription());
        status.setCategory(statusDTO.getCategory());

        return status;
    }

    public static StatusMapper getInstance() {
        return INSTANCE;
    }
}